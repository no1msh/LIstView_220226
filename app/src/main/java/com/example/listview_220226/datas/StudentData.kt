package com.example.listview_220226.datas

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String,
) {

//    연도를 받아서 -> 그 해의 나이를 계산해주는 함수

    fun getKoreaAge ( year : Int) : Int {

        val age = year - birthYear +1

        return age
    }

}