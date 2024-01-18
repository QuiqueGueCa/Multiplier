package com.example.multiplier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.multiplier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: NumBoxAdapter
    private lateinit var mGridLayout: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }



    private fun setupRecyclerView() {
        val boxList = mutableListOf<NumBox>()
        mAdapter = NumBoxAdapter(boxList, this)
        mGridLayout = GridLayoutManager(this, 2)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }

    }

    override fun onClick(numBox: NumBox) {
        mAdapter.update(numBox)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){

            R.id.action_add ->{

                val numBox = NumBox()

                mAdapter.add(numBox)

                true

            }else -> super.onOptionsItemSelected(item)
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        inflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }*/

}