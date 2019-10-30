package com.dlm.batches

import org.apache.spark.rdd.RDD
import org.apache.spark.sql._
import org.apache.spark.sql.types._

import com.dlm.schema._
import org.apache.spark.sql.functions.count

class BrandsBatch extends Batch {

  def select(rdd: Dataset[Row]): RDD[Row] = {

    val fields = List(Events.Year, Events.Month, Events.Day, Events.FreeShipping, Events.Brand)
    rdd.groupBy(fields.head, fields.tail:_*).agg(count("*").as(Events.Counter)).rdd
  }

  def getSchema: StructType = Schemas.brandsSchema

  def getPartitions: List[String] = List(Events.Year, Events.Month, Events.Day)

}
