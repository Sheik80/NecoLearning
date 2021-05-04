package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.constance.Constance
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding : ActivityMainBinding
//Сделать ДЗ по Имени вывести зарплату, Сергей, Алексеей, Андрей

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
  /*          dataBinding.btResult.setOnClickListener {
            //Здесь мы забираем текст из поля ввода rdValue и затем преобразовываем его сначала в стринг,
                // потому что текст мы не можем сразу преобразовать в инт,
                // а затем уже полученный стрнг из текста приводим в int
                val resultData = dataBinding.edValue.text.toString().toInt()
                        //здесь в логе будем смотреть что мы получаем от ввода данных
                Log.d("MyLogOn", "Result= $resultData")
                when(resultData){
                    in 0..1000 -> {
                        dataBinding.tvResult.visibility = View.VISIBLE
                        dataBinding.tvResult.text = "Norm"}
                    in 1000..100000 -> {
                        dataBinding.tvResult.visibility = View.VISIBLE
                        dataBinding.tvResult.text = "Super"}

                    else -> {dataBinding.tvResult.visibility = View.VISIBLE
                         dataBinding.tvResult.text = "Mega"}
                }
            }
  */
        dataBinding.btResult.setOnClickListener {

            val resultName =dataBinding.edName.text.toString()

            when(resultName){
                Constance.DIRECTOR -> {
                    dataBinding.tvResult.visibility = View.VISIBLE
                    //Нельзя напрямую передвать из объекта с констаттами в текствью сначала нужно создать текст из константы, т.е. собрать строку а потом с ней работать
                    //МОжет быть ошибка что строка еще не собрана, а мы ее вызываем

                    val tempSalary = "Получите вашу ЗП ${Constance.DIRECTOR_SALARY}"

                    //Добавляем проверку на совпадение пароля
                    if (dataBinding.edPass.text.toString() == Constance.DIRECTOR_PASSWORD) {

                        dataBinding.tvResult.text = tempSalary
                    } else{
                        dataBinding.tvResult.text = "Password wrong"
                    }
                }
                //Другой вариант написания if else
                Constance.INGENER -> {
                    val tempSalary = "Получите вашу ЗП ${Constance.INGENER_SALARY}"
                    dataBinding.tvResult.visibility = View.VISIBLE
                    dataBinding.tvResult.text = if (dataBinding.edPass.text.toString() == Constance.INGENER_PASSWORD) {
                        tempSalary
                    } else
                    {
                        "Password wrong"
                    }
                }
                Constance.WORKER -> {
                    val tempSalary = "Получите вашу ЗП ${Constance.WORKER_SALARY}"
                    dataBinding.tvResult.text = if (dataBinding.edPass.text.toString() == Constance.WORKER_PASSWORD) {
                        tempSalary
                    } else
                    {
                        "Password wrong"
                    }
                }
                else -> {
                    dataBinding.tvResult.visibility = View.VISIBLE
                    dataBinding.tvResult.text = "Нет такого"
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

/*
    object Constance{
        //Константы сделаны для удобства изменения
        const val DIRECTOR_SALARY = "10000$"
        const val INGENER_SALARY = "1000$"
        const val WORKER_SALARY = "100$"

        const val DIRECTOR = "Alex"
        const val INGENER = "Sergey"
        const val WORKER = "Andry"
    }
*/
}