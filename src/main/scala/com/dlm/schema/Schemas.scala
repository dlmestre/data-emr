package com.dlm.schema

import com.dlm.schema.Events._
import org.apache.spark.sql.types.StructType

object Schemas {

  def fullSchema: StructType = StructType(
    List(
      brand(false),
      categories(false),
      customer(false),
      dd(false),
      freeShipping(false),
      hierarchicalCategories(false),
      hh(false),
      image(false),
      mm(false),
      objectID(false),
      price(false),
      priceRange(false),
      rating(false),
      timestamp(false),
      productType(false),
      yy(false),
      yyyymmddhh(false)
    )
  )

  def brandsSchema: StructType = StructType(
    List(
      yy(false),
      mm(false),
      dd(false),
      freeShipping(false),
      brand(false),
      counting(false)
    )
  )

}
