package com.MGH.quraan;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import com.MGH.quraan.Plus.Data;
import com.MGH.quraan.Plus.ListAdapterr;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ListActivity extends AppCompatActivity {
    ListAdapterr adapter;
    ArrayList<Data> arraylist = new ArrayList();
    ListView listView;

    @Override
    public void onCreate(Bundle paramBundle) {

        super.onCreate(paramBundle);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayOptions(R.styleable.ActionBar_indeterminateProgressStyle);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
         AdView mAdView;

        MobileAds.initialize(this, "ca-app-pub-2736518314640941~6047833569");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2736518314640941/1230621153");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
        TextView textViewTitle = findViewById(R.id.title_text);

        textViewTitle.setText(getString(R.string.app_name));


        listView = findViewById(R.id.listviewidx);
        String[] nameSuraArray = {getString(R.string.Sura1),
                getString(R.string.Sura2),
                getString(R.string.Sura3),
                getString(R.string.Sura4),
                getString(R.string.Sura5),
                getString(R.string.Sura6),
                getString(R.string.Sura7),
                getString(R.string.Sura8),
                getString(R.string.Sura9),
                getString(R.string.Sura10),
                getString(R.string.Sura11),
                getString(R.string.Sura12),
                getString(R.string.Sura13),
                getString(R.string.Sura14),
                getString(R.string.Sura15),
                getString(R.string.Sura16),
                getString(R.string.Sura17),
                getString(R.string.Sura18),
                getString(R.string.Sura19),
                getString(R.string.Sura20),
                getString(R.string.Sura21),
                getString(R.string.Sura22),
                getString(R.string.Sura23),
                getString(R.string.Sura24),
                getString(R.string.Sura25),
                getString(R.string.Sura26),
                getString(R.string.Sura27),
                getString(R.string.Sura28),
                getString(R.string.Sura29),
                getString(R.string.Sura30),
                getString(R.string.Sura31),
                getString(R.string.Sura32),
                getString(R.string.Sura33),
                getString(R.string.Sura34),
                getString(R.string.Sura35),
                getString(R.string.Sura36),
                getString(R.string.Sura37),
                getString(R.string.Sura38),
                getString(R.string.Sura39),
                getString(R.string.Sura40),
                getString(R.string.Sura41),
                getString(R.string.Sura42),
                getString(R.string.Sura43),
                getString(R.string.Sura44),
                getString(R.string.Sura45),
                getString(R.string.Sura46),
                getString(R.string.Sura47),
                getString(R.string.Sura48),
                getString(R.string.Sura49),
                getString(R.string.Sura50),
                getString(R.string.Sura51),
                getString(R.string.Sura52),
                getString(R.string.Sura53),
                getString(R.string.Sura54),
                getString(R.string.Sura55),
                getString(R.string.Sura56),
                getString(R.string.Sura57),
                getString(R.string.Sura58),
                getString(R.string.Sura59),
                getString(R.string.Sura60),
                getString(R.string.Sura61),
                getString(R.string.Sura62),
                getString(R.string.Sura63),
                getString(R.string.Sura64),
                getString(R.string.Sura65),
                getString(R.string.Sura66),
                getString(R.string.Sura67),
                getString(R.string.Sura68),
                getString(R.string.Sura69),
                getString(R.string.Sura70),
                getString(R.string.Sura71),
                getString(R.string.Sura72),
                getString(R.string.Sura73),
                getString(R.string.Sura74),
                getString(R.string.Sura75),
                getString(R.string.Sura76),
                getString(R.string.Sura77),
                getString(R.string.Sura78),
                getString(R.string.Sura79),
                getString(R.string.Sura80),
                getString(R.string.Sura81),
                getString(R.string.Sura82),
                getString(R.string.Sura83),
                getString(R.string.Sura84),
                getString(R.string.Sura85),
                getString(R.string.Sura86),
                getString(R.string.Sura87),
                getString(R.string.Sura88),
                getString(R.string.Sura89),
                getString(R.string.Sura90),
                getString(R.string.Sura91),
                getString(R.string.Sura92),
                getString(R.string.Sura93),
                getString(R.string.Sura94),
                getString(R.string.Sura95),
                getString(R.string.Sura96),
                getString(R.string.Sura97),
                getString(R.string.Sura98),
                getString(R.string.Sura99),
                getString(R.string.Sura100),
                getString(R.string.Sura101),
                getString(R.string.Sura102),
                getString(R.string.Sura103),
                getString(R.string.Sura104),
                getString(R.string.Sura105),
                getString(R.string.Sura106),
                getString(R.string.Sura107),
                getString(R.string.Sura108),
                getString(R.string.Sura109),
                getString(R.string.Sura110),
                getString(R.string.Sura111),
                getString(R.string.Sura112),
                getString(R.string.Sura113),
                getString(R.string.Sura114)};
        String[] LinkArray = {getString(R.string.Link1),
                getString(R.string.Link2),
                getString(R.string.Link3),
                getString(R.string.Link4),
                getString(R.string.Link5),
                getString(R.string.Link6),
                getString(R.string.Link7),
                getString(R.string.Link8),
                getString(R.string.Link9),
                getString(R.string.Link10),
                getString(R.string.Link11),
                getString(R.string.Link12),
                getString(R.string.Link13),
                getString(R.string.Link14),
                getString(R.string.Link15),
                getString(R.string.Link16),
                getString(R.string.Link17),
                getString(R.string.Link18),
                getString(R.string.Link19),
                getString(R.string.Link20),
                getString(R.string.Link21),
                getString(R.string.Link22),
                getString(R.string.Link23),
                getString(R.string.Link24),
                getString(R.string.Link25),
                getString(R.string.Link26),
                getString(R.string.Link27),
                getString(R.string.Link28),
                getString(R.string.Link29),
                getString(R.string.Link30),
                getString(R.string.Link31),
                getString(R.string.Link32),
                getString(R.string.Link33),
                getString(R.string.Link34),
                getString(R.string.Link35),
                getString(R.string.Link36),
                getString(R.string.Link37),
                getString(R.string.Link38),
                getString(R.string.Link39),
                getString(R.string.Link40),
                getString(R.string.Link41),
                getString(R.string.Link42),
                getString(R.string.Link43),
                getString(R.string.Link44),
                getString(R.string.Link45),
                getString(R.string.Link46),
                getString(R.string.Link47),
                getString(R.string.Link48),
                getString(R.string.Link49),
                getString(R.string.Link50),
                getString(R.string.Link51),
                getString(R.string.Link52),
                getString(R.string.Link53),
                getString(R.string.Link54),
                getString(R.string.Link55),
                getString(R.string.Link56),
                getString(R.string.Link57),
                getString(R.string.Link58),
                getString(R.string.Link59),
                getString(R.string.Link60),
                getString(R.string.Link61),
                getString(R.string.Link62),
                getString(R.string.Link63),
                getString(R.string.Link64),
                getString(R.string.Link65),
                getString(R.string.Link66),
                getString(R.string.Link67),
                getString(R.string.Link68),
                getString(R.string.Link69),
                getString(R.string.Link70),
                getString(R.string.Link71),
                getString(R.string.Link72),
                getString(R.string.Link73),
                getString(R.string.Link74),
                getString(R.string.Link75),
                getString(R.string.Link76),
                getString(R.string.Link77),
                getString(R.string.Link78),
                getString(R.string.Link79),
                getString(R.string.Link80),
                getString(R.string.Link81),
                getString(R.string.Link82),
                getString(R.string.Link83),
                getString(R.string.Link84),
                getString(R.string.Link85),
                getString(R.string.Link86),
                getString(R.string.Link87),
                getString(R.string.Link88),
                getString(R.string.Link89),
                getString(R.string.Link90),
                getString(R.string.Link91),
                getString(R.string.Link92),
                getString(R.string.Link93),
                getString(R.string.Link94),
                getString(R.string.Link95),
                getString(R.string.Link96),
                getString(R.string.Link97),
                getString(R.string.Link98),
                getString(R.string.Link99),
                getString(R.string.Link100),
                getString(R.string.Link101),
                getString(R.string.Link102),
                getString(R.string.Link103),
                getString(R.string.Link104),
                getString(R.string.Link105),
                getString(R.string.Link106),
                getString(R.string.Link107),
                getString(R.string.Link108),
                getString(R.string.Link109),
                getString(R.string.Link110),
                getString(R.string.Link111),
                getString(R.string.Link112),
                getString(R.string.Link113),
                getString(R.string.Link114)};

        String[] linkPDF = {
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-01.html#qur001",
                  "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-01.html#qur002",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-03.html#qur003",
                  "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-04.html#qur004",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-06.html#qur005",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-07.html#qur006",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-08.html#qur007",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-09.html#qur008",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-10.html#qur009",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-11.html#qur010",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-11.html#qur011",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-12.html#qur012",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-13.html#qur013",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-13.html#qur014",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-14.html#qur015",
                  "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-14.html#qur016",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-15.html#qur017",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-15.html#qur018",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-16.html#qur019",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-16.html#qur020",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-17.html#qur021",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-17.html#qur022",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-18.html#qur023",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur024",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur025",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-19.html#qur026",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-19.html#qur027",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-20.html#qur028",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-20.html#qur029",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-21.html#qur030",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-21.html#qur031",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-21.html#qur032",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-21.html#qur033",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-22.html#qur034",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-22.html#qur035",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-22.html#qur036",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-23.html#qur037",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-23.html#qur038",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-23.html#qur039",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-24.html#qur040",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-24.html#qur041",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-25.html#qur042",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-25.html#qur043",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-25.html#qur044",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-25.html#qur045",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur046",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur047",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur048",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur049",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur050",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur051",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-26.html#qur052",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-27.html#qur053",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-27.html#qur054",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-27.html#qur055",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-27.html#qur056",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-27.html#qur057",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur058",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur059",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur060",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur061",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur062",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur063",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur064",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur065",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-28.html#qur066",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur067",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur068",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur069",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur070",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur071",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur072",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur073",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur074",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur075",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur076",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-29.html#qur077",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur078",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur079",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur080",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur081",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur082",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur083",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur084",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur085",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur086",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur087",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur088",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur089",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur090",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur091",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur092",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur093",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur094",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur095",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur096",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur097",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur098",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur099",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur100",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur101",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur102",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur103",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur104",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur105",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur106",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur107",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur108",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur109",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur110",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur111",
                   "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur112",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur113",
                    "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur114",
                "https://alkafeel.net/islamiclibrary/quran/quran/html/quran-30.html#qur114"
        };

        for (int i = 0; i < nameSuraArray.length; i++) {
            Data localData = new Data(nameSuraArray[i], LinkArray[i],linkPDF[i]);
            arraylist.add(localData);

        }
        adapter = new ListAdapterr(arraylist, this);
        listView.setAdapter(this.adapter);
    }



    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.privacy:
                startActivity(new Intent(this,privacyActivity.class));
                return true;
            case R.id.about:
                startActivity(new Intent(this,aboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("إغلاق التطبيق");
        localBuilder.setMessage("هل تريد من خروج من التطبيق؟ ");
        localBuilder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                finish();
            }
        });
        localBuilder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.show();
    }

}