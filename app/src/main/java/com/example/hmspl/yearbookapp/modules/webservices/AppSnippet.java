package com.example.hmspl.yearbookapp.modules.webservices;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hmspl.yearbookapp.R;
import in.hakunamatata.view.activity.BaseActivity;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppSnippet {


  /*  public static AlertDialog showCustomAlertDialog(Context context, String content, String positiveText,
                                                    View.OnClickListener positiveListener,
                                                    String negativeText,
                                                    View.OnClickListener negativeListener) {
        View view = LayoutInflater.from(context).inflate(R.layout.inflater_app_theme_custom_alert_dialog, null);
        TextView contentView = (TextView) view.findViewById(R.id.inflater_app_theme_custom_alert_dialog_content_view);
        TextView positiveView = (TextView) view.findViewById(R.id.inflater_app_theme_custom_alert_dialog_positive_view);
        TextView negativeView = (TextView) view.findViewById(R.id.inflater_app_theme_custom_alert_dialog_negative_view);
        contentView.setText(content);
        if (positiveText != null && positiveListener != null) {
            positiveView.setText(positiveText);
            positiveView.setOnClickListener(positiveListener);
        } else {
            positiveView.setVisibility(View.GONE);
        }
        if (negativeText != null && negativeListener != null) {
            negativeView.setText(negativeText);
            negativeView.setOnClickListener(negativeListener);
        } else {
            negativeView.setVisibility(View.GONE);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        builder.setCancelable(false);

        return builder.show();
    }*/

    public static double getDoublefromString(String value) {
        if (null != value && !value.equals("") && !value.equals(".")) {

            return Double.valueOf(value);
        }
        return 0;
    }

    public static float getFloatfromString(String value) {
        if (null != value && !value.equals("") && !value.equals(".")) {

            return Float.valueOf(value);
        }
        return 0;
    }


    public static void setupToolbar(final BaseActivity activity, Toolbar toolbar, final View.OnClickListener clickListener, String title, boolean isNeedBackButton) {
        activity.setSupportActionBar(toolbar);
        if (null != activity.getSupportActionBar()) {
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if (isNeedBackButton) {
            toolbar.setNavigationIcon(R.drawable.ic_back);
            toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    if (clickListener == null) {
                        activity.hideSoftKeyboard();
                        activity.onBackPressed();
                    } else {
                        clickListener.onClick(v);
                    }
                }
            });
        }
        setupStatusbar(activity, toolbar);
        updateToolbarTitle(toolbar, title);
    }
//
//    public static void setupStatusbar(final BaseActivity activity, Toolbar toolbar) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            if (activity != null) {
//                activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, android.R.color.transparent));
//                final View decorView = activity.getWindow().getDecorView();
//
//                boolean hasSoftKey = hasSoftKeys(activity);
//                int bottomNavigationHeight = 0;
//                if (hasSoftKey) {
//
//                    WindowManager window = activity.getWindowManager();
//
//                    if (window != null) {
//                        Display d = activity.getWindowManager().getDefaultDisplay();
//
//                        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
//                        d.getRealMetrics(realDisplayMetrics);
//
//                        int realHeight = realDisplayMetrics.heightPixels;
//                        int realWidth = realDisplayMetrics.widthPixels;
//
//                        DisplayMetrics displayMetrics = new DisplayMetrics();
//                        d.getMetrics(displayMetrics);
//
//                        int displayHeight = displayMetrics.heightPixels;
//                        int displayWidth = displayMetrics.widthPixels;
//
//                        bottomNavigationHeight = realHeight-displayHeight;
//                    }
//                }
//                Rect rectangle = new Rect();
//                Window window = activity.getWindow();
//                window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//                window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
//
//                int contentViewTop =
//                        window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
//                if (hasSoftKey) {
//                    window.getDecorView().setBottom(bottomNavigationHeight);
//                    window.findViewById(Window.ID_ANDROID_CONTENT).setBackgroundColor(ContextCompat.getColor(activity,android.R.color.black));
//                    window.findViewById(Window.ID_ANDROID_CONTENT).setPadding(0,0,0,bottomNavigationHeight);
//                }
//                int statusBarHeight = rectangle.top;
//                int titleBarHeight = contentViewTop - statusBarHeight;
//                TypedValue tv = new TypedValue();
//                int toolbarHeight = 0;
//                int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
//                if (resourceId > 0) {
//                    titleBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
//                }
//                if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
//                    toolbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, activity.getResources().getDisplayMetrics());
//                }
//                if (toolbar.getParent() instanceof LinearLayout) {
//                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, toolbarHeight);
//                    layoutParams.setMargins(0, titleBarHeight, 0, 0);
//                    toolbar.setLayoutParams(layoutParams);
//                } else if (toolbar.getParent() instanceof RelativeLayout) {
//                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, toolbarHeight);
//                    layoutParams.setMargins(0, titleBarHeight, 0, 0);
//                    toolbar.setLayoutParams(layoutParams);
//                }
//            }
//        }
//    }

    public static void setupStatusbar(final BaseActivity activity, Toolbar toolbar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (activity != null) {
                activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.black_op_20));
                View decorView = activity.getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

                decorView.setSystemUiVisibility(uiOptions);
                Rect rectangle = new Rect();
                Window window = activity.getWindow();
                window.getDecorView().getWindowVisibleDisplayFrame(rectangle);

                int contentViewTop =
                        window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
                int statusBarHeight = rectangle.top;
                int titleBarHeight = contentViewTop - statusBarHeight;
                TypedValue tv = new TypedValue();
                int toolbarHeight = 0;
                int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (resourceId > 0) {
                    titleBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
                }
                if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                    toolbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, activity.getResources().getDisplayMetrics());
                }
                if (toolbar.getParent() instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, toolbarHeight);
                    layoutParams.setMargins(0, titleBarHeight, 0, 0);
                    toolbar.setLayoutParams(layoutParams);
                } else if (toolbar.getParent() instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, toolbarHeight);
                    layoutParams.setMargins(0, titleBarHeight, 0, 0);
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
    }

   /* public static String getFormattedDateString(String date, String currentFormet, String neededFormat) {

        String value = "";
        Calendar now = getCalender();
        String tempDate = CodeSnippet.getFormattedDateString(date, neededFormat, currentFormet);
        String today = new SimpleDateFormat(currentFormet).format(now.getTime());
        now.set(Calendar.DATE, ((now.get(Calendar.DATE) - 1)));
        if (tempDate != null) {
            if (tempDate.equals(today)) {
                value = DataHandler.getInstance().getLanguage().getPlanning().getToday();
            } else {
                value = tempDate;
            }
        }
        return value;
    }*/

    /*public static String getFormattedTimeString(String time, String currentFormet, String neededFormat) {

        String value = "";
        String tempDate = CodeSnippet.getDateStringFromDate(CodeSnippet.getDateFromDateString(time, currentFormet), neededFormat);
        if (tempDate != null) {
            value = tempDate;
        }
        return value;
    }*/

    public static void updateToolbarTitle(Toolbar toolbar, String title) {
        try {
            ((TextView) toolbar.findViewById(R.id.inflater_toolbar_title)).setText(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to set full screen mode
     *
     * @param activity Activity for which the screen should be in full screen mode
     */
    public static void setFullScreen(Activity activity) {

        View decorView = activity.getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOptions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        }
    }

    public static void revertFullScreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);
    }

   /* public static void setupMenuToolbar(NavigationMenuActivity activity, Toolbar toolbar) {
        activity.setSupportActionBar(toolbar);
        ActionBar ab = activity.getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        setupStatusbar(activity, toolbar);
    }*/




    public static String getMonthFromDate(Date date) {
        if (null != date) {

        }
        return "";
    }

    public static Calendar getCalender() {
        return Calendar.getInstance();
    }

 /*   public static Date getDateFromResponseDateString(String startTime) {
        return CodeSnippet.getUTCDateTimeFromString(startTime, Constants.Dateformat_As_UX.SERVER_TIME_ZONE_FORMAT);
    }

    public static String getRequestGmtDateString(Date time) {
        return CodeSnippet.formatDateString(time, Constants.Dateformat_As_UX.SERVER_TIME_ZONE_FORMAT, Constants.Dateformat_As_UX.SERVER_TIME_ZONE_FORMAT);
    }

    public static String getRequestGmtDateString(Date time, String serverDateFormat) {
        return CodeSnippet.formatDateString(time, serverDateFormat, Constants.Dateformat_As_UX.SERVER_TIME_ZONE_FORMAT);
    }

    public static String getFormattedDateFromRequest(String startTime, String requestedFormat) {
        return CodeSnippet.getDateStringFromDate(CodeSnippet.getUTCDateTimeFromString(startTime, Constants.Dateformat_As_UX.SERVER_TIME_ZONE_FORMAT), requestedFormat);
    }

    public static String getOrderNo(String id) {
        if (!Validation.isEmpty(id)) {
            if (id.charAt(0) == '#') {
                id = id.substring(1, id.length());
            }
        }
        return id;
    }*/

    public static void disableOnClick(final View view) {
        view.setEnabled(false);
        new CountDownTimer(900, 900) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                view.setEnabled(true);
            }
        }.start();
    }

  /*  public static String getGmtCurrentTime() {
        return getRequestGmtDateString(getCalender().getTime());
    }*/

    private static boolean hasSoftKeys(BaseActivity activity) {
        boolean hasSoftwareKeys;
        if (activity == null) {
            return false;
        }
        WindowManager window = activity.getWindowManager();

        if (window != null) {
            Display d = activity.getWindowManager().getDefaultDisplay();

            DisplayMetrics realDisplayMetrics = new DisplayMetrics();
            d.getRealMetrics(realDisplayMetrics);

            int realHeight = realDisplayMetrics.heightPixels;
            int realWidth = realDisplayMetrics.widthPixels;

            DisplayMetrics displayMetrics = new DisplayMetrics();
            d.getMetrics(displayMetrics);

            int displayHeight = displayMetrics.heightPixels;
            int displayWidth = displayMetrics.widthPixels;

            hasSoftwareKeys = (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
        } else {
            boolean hasMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
            boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

            hasSoftwareKeys = !hasMenuKey && !hasBackKey;
        }

        return hasSoftwareKeys;
    }

  /*  public static String getLocation(Object object) {
        String address = "";
        String street = "", streetNr = "", zip = "", city = "";
        if (object instanceof Client) {
            Client client = ((Client) object);
            street = client.getStreet();
            streetNr += client.getStreet_nr();
            zip += client.getZip();
            city += client.getCity();
        } else if (object instanceof Staff) {
            Staff staff = ((Staff) object);
            street = staff.getStreet();
            streetNr += staff.getStreet_nr();
            zip += staff.getZip();
            city += staff.getCity();
        } else if (object instanceof Doctor) {
            Doctor doctor = ((Doctor) object);
            street = doctor.getStreet();
            streetNr += doctor.getStreet_nr();
            zip += doctor.getZip();
            city += doctor.getCity();
        }
        if (!Validation.isEmpty(street)) {
            address += street;
        }
        if (!Validation.isEmpty(streetNr)) {
            address += (" " + streetNr);
        }
        if (!Validation.isEmpty(zip)) {
            if (!Validation.isEmpty(address)) {
                address += ", ";
            }
            address += zip;
        }
        if (!Validation.isEmpty(city)) {
            address += (" " + city);

        }
        return address.trim();
    }*/
}


