package com.example.listview_220226.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.listview_220226.datas.StudentData

class StudentAdapter (
    val mContext : Context, // 어느 화면에서?
    val resId: Int, // 어떤 xml을 기반으로?
    val mList : ArrayList<StudentData>  // 그래서 실제로 뿌려줄 학생들은 누구누구냐? 목록
)
    : ArrayAdapter<StudentData>(mContext,resId,mList) {
}