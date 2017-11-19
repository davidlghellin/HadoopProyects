/* GenerateNames.scala */

import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

object GenerateNames {
  val outputDir = "/home/wizord/prueba"

  def main(args: Array[String]) {
    val conf = new SparkConf()

    val sc = new SparkContext(conf)

    for (partition <- 0 to 3) {
      val data = Seq.fill(1000000)(Random.alphanumeric.take(5).mkString)
      sc.parallelize(data, 1).saveAsTextFile(outputDir + "_" + partition)
    }

  }
}