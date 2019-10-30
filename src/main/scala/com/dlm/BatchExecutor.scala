package com.dlm

import java.util.Date

import com.dlm.batches.Batch
import com.dlm.schema._
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._
import org.joda.time.DateTime

class BatchExecutor(batcher: Batch) extends Serializable {

  val _appname = "Records"
  @transient lazy val conf: SparkConf = new SparkConf().setAppName(_appname)
  @transient lazy val sc: SparkContext = new SparkContext(conf)

  @throws[InterruptedException]
  def run(input: String,
              output: String,
              from: Date,
              to: Date,
              customer: String): Unit = {

    val sparkSession = SparkSession.builder
      .config(sc.getConf)
      .getOrCreate

    val rdd = read(sparkSession, input, from, to)
      .where(new Column(Events.Customer).equalTo(customer))

    val filtered = batcher.select(rdd)
    save(sparkSession, filtered, batcher.getSchema, output, batcher.getPartitions)
    sc.stop()

  }

  def read(sparkSession: SparkSession, input: String, from: Date, to: Date): Dataset[Row] = {
    val fromDT = new DateTime(from.getTime)
    val toDT   = new DateTime(to.getTime)

    val fromYyyyMmDdHh = "%04d%02d%02d%02d".format(fromDT.getYear,
      fromDT.getMonthOfYear,
      fromDT.getDayOfMonth,
      fromDT.getHourOfDay)

    val toYyyyMmDdHh = "%04d%02d%02d%02d".format(toDT.getYear,
      toDT.getMonthOfYear,
      toDT.getDayOfMonth,
      toDT.getHourOfDay)

    val all = sparkSession.read
      .schema(Schemas.fullSchema)
      .parquet(input)

    val yyyymmddhh = new Column(Events.YyyyMmDdHh)

    all
      .filter(yyyymmddhh.geq(fromYyyyMmDdHh))
      .filter(yyyymmddhh.leq(toYyyyMmDdHh))
  }

  def save(sparkSession: SparkSession,
           rdd: RDD[Row],
           schema: StructType,
           output: String,
           partitions: List[String]): Unit =
    sparkSession
      .createDataFrame(rdd, schema)
      .write
      .mode(SaveMode.Append)
      .partitionBy(partitions:_*)
      .parquet(output)
}
