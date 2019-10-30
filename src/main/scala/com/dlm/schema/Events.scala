package com.dlm.schema

import org.apache.spark.sql.types._

object Events {
  val YyyyMmDdHh             = "yyyymmddhh"
  val Year                   = "year"
  val Month                  = "month"
  val Day                    = "day"
  val Hour                   = "hour"
  val Brand                  = "brand"
  val Categories             = "categories"
  val FreeShipping           = "free_shipping"
  val HierarchicalCategories = "hierarchicalCategories"
  val Image                  = "image"
  val ObjectID               = "objectID"
  val Price                  = "price"
  val PriceRange             = "price_range"
  val Rating                 = "rating"
  val ProductType            = "type"
  val Timestamp              = "timestamp"
  val Customer               = "customer"
  val Counter                = "count"

  def yyyymmddhh(nullable: Boolean)              = StructField(YyyyMmDdHh, StringType, nullable = nullable)
  def yy(nullable: Boolean)                      = StructField(Year, LongType, nullable = nullable)
  def mm(nullable: Boolean)                      = StructField(Month, LongType, nullable = nullable)
  def dd(nullable: Boolean)                      = StructField(Day, LongType, nullable = nullable)
  def hh(nullable: Boolean)                      = StructField(Hour, LongType, nullable = nullable)
  def brand(nullable: Boolean)                   = StructField(Brand, StringType, nullable = nullable)
  def categories(nullable: Boolean)              = StructField(Categories, ArrayType(StringType, containsNull = nullable), nullable = nullable)
  def freeShipping(nullable: Boolean)            = StructField(FreeShipping, BooleanType, nullable = nullable)
  def hierarchicalCategories(nullable: Boolean)  = StructField(HierarchicalCategories, ArrayType(StringType, containsNull = nullable), nullable = nullable)
  def image(nullable: Boolean)                   = StructField(Image, StringType, nullable = nullable)
  def objectID(nullable: Boolean)                = StructField(ObjectID, StringType, nullable = nullable)
  def price(nullable: Boolean)                   = StructField(Price, StringType, nullable = nullable)
  def priceRange(nullable: Boolean)              = StructField(PriceRange, StringType, nullable = nullable)
  def rating(nullable: Boolean)                  = StructField(Rating, StringType, nullable = nullable)
  def productType(nullable: Boolean)             = StructField(ProductType, StringType, nullable = nullable)
  def timestamp(nullable: Boolean)               = StructField(Timestamp, StringType, nullable = nullable)
  def customer(nullable: Boolean)                = StructField(Customer, StringType, nullable = nullable)
  def counting(nullable: Boolean)                = StructField(Counter, LongType, nullable = nullable)

}
