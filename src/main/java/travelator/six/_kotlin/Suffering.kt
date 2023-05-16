package travelator.six._kotlin

import travelator.six._java.Journey

object Suffering {

  /**
   * 이런식으로 특정 자료형만의 정렬 함수를 설정 가능
   * 여기서 take 는 limit 수 만큼 list 를 리턴
   */
  @JvmStatic
  fun List<Journey>.longestJourneys(limit: Int): List<Journey> = sortedByDescending { it.duration }.take(limit)
}