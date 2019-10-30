package com.dlm.config

import com.beust.jcommander._

object Args {
  @Parameter(
    names = Array("-h", "--help"), help = true)
  var help = false
  @Parameter(
    names = Array("-i", "--input"),
    description = "Input path",
    required = true)
  var input: String = null
  @Parameter(
    names = Array("-o", "--output"),
    description = "Input path",
    required = true)
  var output: String = null
  @Parameter(
    names = Array("-f", "--from"),
    description = "End date",
    required = true)
  var fromDate: String = null
  @Parameter(
    names = Array("-t", "--to"),
    description = "Start date",
    required = true)
  var toDate: String = null
  @Parameter(
    names = Array("-b", "--batch"),
    description = "Batch name",
    required = true)
  var batchName: String = null
  @Parameter(
    names = Array("-c", "--customer"),
    description = "Customer name",
    required = true)
  var customer: String = null

}