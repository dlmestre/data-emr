package com.dlm.batches

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Dataset, Row}

trait Batch extends Serializable {
  def select(rdd: Dataset[Row]): RDD[Row]
  def getSchema: StructType
  def getPartitions: List[String]
}