#!/usr/bin/env Rscript
args <- commandArgs(TRUE)

sayHello <- function(x){
   print(2 + 4 + as.numeric(x))
}

sayHello(args)
