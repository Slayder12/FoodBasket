package com.example.foodbasket.models

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.foodbasket.database.DBHelper

class MyDialog: DialogFragment() {
    private var dataBase: DBHelper? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataBase = DBHelper(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val item = requireArguments().getSerializable("item") as Item
        val builder = android.app.AlertDialog.Builder(
            requireActivity()
        )

        return builder
            .setTitle("Добавить в корзину \"${item.name}\".")
            .setMessage("Выберите действие!")
            .setPositiveButton("В корзину") { dialog, which ->
                dataBase!!.addData(item)
                Toast.makeText(
                    context,
                    "${item.name} добавлен(а) в Корзину", Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Отмена", null)
            .create()
    }

}