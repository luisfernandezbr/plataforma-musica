package movile.music;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;import bhouse.travellist.R;

/**
 * Created by megha on 15-03-06.
 */
public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.ViewHolder> {

  Context mContext;
  OnItemClickListener mItemClickListener;

  public SongsListAdapter(Context context) {
    this.mContext = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_songs, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    final Place place = new PlaceData().placeList().get(position);

    holder.placeName.setText(place.name);
   // Picasso.with(mContext).load(place.getImageResourceId(mContext)).into(holder.placeImage);

   // Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), place.getImageResourceId(mContext));

   /* Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
      public void onGenerated(Palette palette) {
        int mutedLight = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
        holder.placeNameHolder.setBackgroundColor(mutedLight);
      }
    });*/
  }

  @Override
  public int getItemCount() {
    return new PlaceData().placeList().size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public LinearLayout placeHolder;
    public LinearLayout placeNameHolder;
    public TextView placeName;
    public ImageView placeImage;

    public ViewHolder(View itemView) {
      super(itemView);
      placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
      placeName = (TextView) itemView.findViewById(R.id.placeName);
      placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
      placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
      placeHolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if (mItemClickListener != null) {
        mItemClickListener.onItemClick(itemView, getPosition());

      }
      Animation girar;
      girar = AnimationUtils.loadAnimation(mContext, R.anim.girar);
      girar.reset();
      placeImage.startAnimation(girar);
    }
  }

  public interface OnItemClickListener {
    void onItemClick(View view, int position);
  }

  public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.mItemClickListener = mItemClickListener;
  }

}
