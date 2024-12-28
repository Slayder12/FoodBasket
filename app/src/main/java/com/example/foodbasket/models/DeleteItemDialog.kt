package com.example.foodbasket.models

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.foodbasket.database.DBHelper
import com.example.foodbasket.utils.Updatable

class DeleteItemDialog: DialogFragment() {
    private var dataBase: DBHelper? = null
    private var updatable: Updatable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataBase = DBHelper(context)
        updatable = context as Updatable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val item = requireArguments().getSerializable("item") as Item
        val builder = android.app.AlertDialog.Builder(
            requireActivity()
        )

        return builder
            .setTitle("\"${item.name}\"")
            .setPositiveButton("Удалить из корзины") { dialog, which ->
                dataBase!!.deleteData(item)
                updatable?.update()
                Toast.makeText(
                    context,
                    "${item.name} удален(а) из корзины", Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Отмена", null)
            .create()
    }

}