package pl.kitek.greencoffeeexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import pl.kitek.greencoffeeexample.data.DataSource
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var repo: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        App.get(this).getComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById(R.id.messageText) as TextView).text = repo.getMessage()
    }
}
