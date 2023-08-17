package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.islamy_mohamed.R
import com.islamy_mohamed.TextOfSoraActivity
import com.islamy_mohamed.ui.Home_Screen.HomeActivity

class QuranFragment : Fragment() {
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
        var RV : RecyclerView
        var adapterRv : AdapterForRVQuranFragment
        super.onViewCreated(view, savedInstanceState)
        RV = view.findViewById(R.id.RV_Quran)
        adapterRv = AdapterForRVQuranFragment(ArSuras)
        RV.adapter = adapterRv
        adapterRv.onItemClickListener = object :AdapterForRVQuranFragment.OnItemClickListener{
            override fun OnItemClick(position: Int, name: String) {

            }

        }
    }

}