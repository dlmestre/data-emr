package com.dlm.config

import com.beust.jcommander.JCommander

trait ParseArgs {
  def process(args: Array[String]): Option[(String, String, String, String, String, String)] = {
    val jCommander = new JCommander(Args, args.toArray: _*)
    if (Args.help) {
    jCommander.usage()
    None
  } else
    Some(Args.input, Args.output, Args.fromDate, Args.toDate, Args.batchName, Args.customer)
  }
}