package itachi_waiyan.com.padc_plant_app.views.holders

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView:View) : RecyclerView.ViewHolder(itemView){

    var data : T ?=null
        set(value) {
            Log.d("test---","set")
            field = value
            value?.let {
                bindData(it)
            }
            //non_null data pass to bind with views
            if(value != null){
                bindData(value)
            }
        }

    protected abstract fun bindData(data: T)

}