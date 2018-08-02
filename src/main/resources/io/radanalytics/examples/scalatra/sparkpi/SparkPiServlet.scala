package io.radanalytics.examples.scalatra.sparkpi

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatra.{Ok, ScalatraServlet}

class SparkPiServlet extends ScalatraServlet {
    get( "/sparkpi" ) {
        val spark = new SparkContext( new SparkConf().setAppName( "Radanalytics IO Scalatra Tutorial" ) )
        val sparkPi = new SparkPI( spark,2 ).calculate()
        spark.stop()
        Ok( "Pi is roughly " + sparkPi )
    }
}