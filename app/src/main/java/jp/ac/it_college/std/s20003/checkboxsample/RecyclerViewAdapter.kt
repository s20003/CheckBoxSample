package jp.ac.it_college.std.s20003.checkboxsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderItem>() {
    private val nameList = listOf("Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7", "Name8", "Name9", "Name10")
    companion object {
        var returnSelectValues = mutableListOf<String>()
    }

    inner class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        var selectValues: String = ""

//        private val recyclerAdapter = RecyclerViewAdapter()
//        private val nameList = recyclerAdapter.nameList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.checkBox.text = nameList[position]
        holder.checkBox.setOnClickListener {
            if (holder.checkBox.isChecked) {
                Toast.makeText(holder.itemView.context, "${nameList[position]}を選択しました", Toast.LENGTH_SHORT).show()
                // holder.selectValues.add(nameList[position])
                holder.selectValues = nameList[position]
                // returnSelectValues = holder.selectValues
                returnSelectValues.add(holder.selectValues)
            } else {
                Toast.makeText(holder.itemView.context, "${nameList[position]}の選択を解除しました", Toast.LENGTH_SHORT).show()
                // holder.selectValues.remove(nameList[position])
                returnSelectValues.remove(holder.selectValues)
            }
        }
        // returnSelectValues = holder.selectValues
    }

    override fun getItemCount(): Int = nameList.size

    fun listOfSelectedActivities(): MutableList<String> {
        return returnSelectValues
    }
}