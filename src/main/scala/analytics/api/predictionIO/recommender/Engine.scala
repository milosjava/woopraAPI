package analytics.api.predictionIO.recommender

import io.prediction.controller.{Engine, IEngineFactory}

case class Query(
  user: String,
  num: Int
) extends Serializable

case class PredictedResult(
  itemScores: Array[ItemScore]
) extends Serializable

case class ActualResult(
  ratings: Array[Rating]
) extends Serializable

case class ItemScore(
  item: String,
  score: Double
) extends Serializable

object RecommendationEngine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("als" -> classOf[ALSAlgorithm]),
      classOf[Serving])
  }
}