package com.dlm

import org.joda.time.DateTime
import com.dlm.batches.BrandsBatch
import com.dlm.config.ParseArgs

object Records extends ParseArgs {

  def main(args: Array[String]) : Unit = {

    process(args).foreach {
      case (input, output, fromDate, toDate, batchName, customer) => {
        val batch = batchName match {
          case "brands" =>
            new BatchExecutor(new BrandsBatch())

          case _ =>
            throw new IllegalArgumentException(
              "Unknown bundle {%s}".format(batchName))
        }

        batch.run(input, output, new DateTime(fromDate).toDate, new DateTime(toDate).toDate, customer)
      }
    }

  }
}
