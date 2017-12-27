package com.ocr.test.act2android.model;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;
import com.ocr.test.act2android.MainActivity;
import com.ocr.test.act2android.R;
import com.ocr.test.act2android.WebActivity;

import java.util.List;

/**
 * The Adapter to manage our data and refresh the view
 */

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.MyViewHolder>{

    /**
     * List items
     */
    private List<FakeNews> items;

    /**
     * the resource id of item Layout
     */
    private int itemLayout;


    /**
     * Constructor ListNewsAdapter
     * @param items : the list items
     * @param itemLayout : the resource id of itemView
     */
    public ListNewsAdapter(List<FakeNews> items,int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    /**
     * Get the size of items in adapter
     * @return the size of items in adapter
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Create View Holder by Type
     * @param parent, the view parent
     * @param viewType : the type of View
     * @return view Holder with view parameter
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // get inflater and get view by resource id itemLayout
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new MyViewHolder(v);
    }


    /**
     * Bind (link) View Holder with Items
     * @param holder: the view holder
     * @param position : the current position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(items.get(position).title);
        holder.name.setTag(items.get(position).htmlContent);

        // change background color every row :
        if ((position % 2) == 0) {
            holder.itemView.setBackgroundResource(R.color.color1);
        } else {
            holder.itemView.setBackgroundResource(R.color.color2);
        }
    }

    /**
     *
     * @author boy
     * Class viewHolder
     * Hold a textView - could hold many more stuff !
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        /**
         * Constructor MyViewHolder
         * @param itemView: the itemView
         */
        public MyViewHolder(final View itemView) {

            // initialize itemView field :
            super(itemView);

            name = ((TextView) itemView.findViewById(android.R.id.text1));

            // Set listener on itemView click :
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // should we start activity right here ?
                    Log.i("RecyclerAdapter","Clicked on title " + name.getText());
                    Intent myInt = new Intent(v.getContext(), WebActivity.class);

                    // Passing the url as a string from the tag text of the item
                    myInt.putExtra("url",name.getTag().toString());
                    Log.i("RecyclerAdapter","Launching second activity with HTML ");
                    v.getContext().startActivity(myInt);

                }
            });
        }

    }

}