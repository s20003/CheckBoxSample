package jp.ac.it_college.std.s20003.checkboxsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s20003.checkboxsample.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    private val recyclerViewAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val monHour = intent.getIntExtra("MORNING_HOUR", 24)
        val monMin = intent.getIntExtra("MORNING_MINUTE", 60)
        val noonHour = intent.getIntExtra("NOON_HOUR", 24)
        val noonMin = intent.getIntExtra("NOON_MINUTE", 60)
        val nightHour = intent.getIntExtra("NIGHT_HOUR", 24)
        val nightMin = intent.getIntExtra("NIGHT_MINUTE", 60)

//        binding.textView7.text = monHour.toString()
//        binding.textView8.text = monMin.toString()

        binding.recyclerView.apply {
            adapter = RecyclerViewAdapter()
            layoutManager = LinearLayoutManager(this@NextActivity)
        }

        binding.returnButton.setOnClickListener {
            finish()
        }

        binding.registerButton.setOnClickListener {
            val selectedList = recyclerViewAdapter.listOfSelectedActivities()
            println(selectedList)
//            val intent = Intent(this, DisplayActivity::class.java)
//            for (v in selectedList) {
//                // Intent の処理を書く
//            }
//            startActivity(intent)
        }
        // https://www.youtube.com/watch?v=4uWc34lk2iE 7:35
    }
}