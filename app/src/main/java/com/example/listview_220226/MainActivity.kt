package com.example.listview_220226

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.listview_220226.adapters.StudentAdapter
import com.example.listview_220226.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 학생 목록을 담을 그릇
    val mStudentList = ArrayList<StudentData>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add( StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add( StudentData("권효영", 1995, "서울시 중랑구") )
        mStudentList.add( StudentData("김정환", 1981, "서울시 마포구") )
        mStudentList.add( StudentData("김한균", 1977, "서울시 강남구") )
        mStudentList.add( StudentData("문상현", 1997, "부천시 원미구") )
        mStudentList.add( StudentData("이형종", 1978, "서울시 강서구") )
        mStudentList.add( StudentData("최다영", 1990, "서울시 서대문구") )
        mStudentList.add( StudentData("최민서", 1995, "서울시 송파구") )
        mStudentList.add( StudentData("유석균", 1970, "서울시 동대문구") )

        mAdapter = StudentAdapter( this , R.layout.student_list_item , mStudentList)

        studentListView.adapter = mAdapter
        
        studentListView.setOnItemClickListener { parent, view, position, id -> 
            
//            position : 몇번줄이 눌렀나? 0번줄 부터 출발
            
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name} 학생이 클릭됨", Toast.LENGTH_SHORT).show()
        }
        
        studentListView.setOnItemLongClickListener { parent, view, position, id -> 
            
            val longClickedStudent = mStudentList[position]

//            Toast.makeText(this, "${longClickedStudent.name} 학생이 길게 클릭됨", Toast.LENGTH_SHORT).show()



            val alert = AlertDialog.Builder(this)
                .setTitle("학생 삭제 확인")
                .setMessage("정말 ${longClickedStudent.name} 학생을 삭제하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

//                  확인 버튼이 눌렸을 때
//                  롱클릭된 대상은 삭제 처리
                    mStudentList.remove( longClickedStudent )

//                 내용물을 삭제하고 나면, 리스트 뷰를 다루는 어댑터한테도 알려주자.

                    mAdapter.notifyDataSetChanged()
                })
                .setNegativeButton("취소" , null)
                .show()

            return@setOnItemLongClickListener true
        }
    }
}