package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.islamy_mohamed.R
import com.islamy_mohamed.ui.activitySoraDetails.TextOfSoraActivity

class QuranFragment : Fragment() {
   lateinit var sharedPreferences : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ArSuras = listOf(
            "الفاتحه",
            "البقرة",
            "آل عمران",
            "النساء",
            "المائدة",
            "الأنعام",
            "الأعراف",
            "الأنفال",
            "التوبة",
            "يونس",
            "هود",
            "يوسف",
            "الرعد",
            "إبراهيم",
            "الحجر",
            "النحل",
            "الإسراء",
            "الكهف",
            "مريم",
            "طه",
            "الأنبياء",
            "الحج",
            "المؤمنون",
            "النّور",
            "الفرقان",
            "الشعراء",
            "النّمل",
            "القصص",
            "العنكبوت",
            "الرّوم",
            "لقمان",
            "السجدة",
            "الأحزاب",
            "سبأ",
            "فاطر",
            "يس",
            "الصافات",
            "ص",
            "الزمر",
            "غافر",
            "فصّلت",
            "الشورى",
            "الزخرف",
            "الدّخان",
            "الجاثية",
            "الأحقاف",
            "محمد",
            "الفتح",
            "الحجرات",
            "ق",
            "الذاريات",
            "الطور",
            "النجم",
            "القمر",
            "الرحمن",
            "الواقعة",
            "الحديد",
            "المجادلة",
            "الحشر",
            "الممتحنة",
            "الصف",
            "الجمعة",
            "المنافقون",
            "التغابن",
            "الطلاق",
            "التحريم",
            "الملك",
            "القلم",
            "الحاقة",
            "المعارج",
            "نوح",
            "الجن",
            "المزّمّل",
            "المدّثر",
            "القيامة",
            "الإنسان",
            "المرسلات",
            "النبأ",
            "النازعات",
            "عبس",
            "التكوير",
            "الإنفطار",
            "المطفّفين",
            "الإنشقاق",
            "البروج",
            "الطارق",
            "الأعلى",
            "الغاشية",
            "الفجر",
            "البلد",
            "الشمس",
            "الليل",
            "الضحى",
            "الشرح",
            "التين",
            "العلق",
            "القدر",
            "البينة",
            "الزلزلة",
            "العاديات",
            "القارعة",
            "التكاثر",
            "العصر",
            "الهمزة",
            "الفيل",
            "قريش",
            "الماعون",
            "الكوثر",
            "الكافرون",
            "النصر",
            "المسد",
            "الإخلاص",
            "الفلق",
            "الناس"
        )
        val RV : RecyclerView
        val btnMode : Button
        val adapterRv : AdapterForRVQuranFragment
        super.onViewCreated(view, savedInstanceState)
        RV = view.findViewById(R.id.RV_Quran)
        btnMode = view.findViewById(R.id.mode)
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            btnMode.text = "Light Mode"
        }
        else
        {
            btnMode.text = "Dark Mode"
        }
        btnMode.setOnClickListener {
            if(btnMode.text.toString() == "Dark Mode")
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                modeSharedpreference(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else if(btnMode.text.toString() == "Light Mode")
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                modeSharedpreference(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        adapterRv = AdapterForRVQuranFragment(ArSuras)
        RV.adapter = adapterRv
        adapterRv.onItemClickListener = object :AdapterForRVQuranFragment.OnItemClickListener{
            override fun OnItemClick(position: Int, name: String) {
                val intent = Intent(context , TextOfSoraActivity::class.java)
                 intent.putExtra("indix",position+1)
                 intent.putExtra("nameOfSora",name)
                startActivity(intent)

            }
        }
    }
    fun modeSharedpreference(mode : Int)
    {
        sharedPreferences = requireContext().getSharedPreferences("mode",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("modeNow",mode)
        editor.apply()
    }

}