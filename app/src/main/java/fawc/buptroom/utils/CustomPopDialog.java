package fawc.buptroom.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

import fawc.buptroom.R;

public class CustomPopDialog extends Dialog {

    private CustomPopDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private final Context context;
        private Bitmap image;

        public Builder(Context context) {
            this.context = context;
        }

        Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }

        public CustomPopDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CustomPopDialog dialog = new CustomPopDialog(context, R.style.Dialog);
            View layout = null;
            if (inflater != null) {
                layout = inflater.inflate(R.layout.qrshare, null);
            }
            if (layout != null) {
                dialog.addContentView(layout, new LayoutParams(
                        android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                        , android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            assert layout != null;
            dialog.setContentView(layout);
            ImageView img = layout.findViewById(R.id.img_qrcode);
            img.setImageBitmap(getImage());
            Button shareBtn = layout.findViewById(R.id.share_bt);
            shareBtn.setOnClickListener(view -> {
                String shareContent = "  Stay Hungry Stay Foolish\n" +
                        "Stay Studying With BuptRoom\n" +
                        "————————————————\n" +
                        "   http://d.firim.top/BuptRoom\n" +
                        "————————————————";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareContent);
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent, "分享到"));
            });
            return dialog;
        }
    }
}