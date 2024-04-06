package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.islamy_mohamed.databinding.FragmentQuranBinding
import com.islamy_mohamed.ui.activitySoraDetails.TextOfSoraActivity

class QuranFragment : Fragment() {
   private lateinit var sharedPreferences : SharedPreferences
   private lateinit var viewBinding : FragmentQuranBinding
    private lateinit var adapterRv : AdapterQuranFragment
    private val surahesList = listOf(
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentQuranBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMode()
        initFunction()
    }

    private fun initFunction() {
        adapterRv = AdapterQuranFragment(surahesList)
        viewBinding.RVQuran.adapter = adapterRv
        adapterRv.onItemClickListener = object : AdapterQuranFragment.OnItemClickListener {
            override fun onItemClick(position: Int, name: String) {
                val intent = Intent(context, TextOfSoraActivity::class.java)
                intent.putExtra("index", position + 1)
                intent.putExtra("nameOfSora", name)
                startActivity(intent)

            }
        }
    }

    private fun setMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            viewBinding.mode.text = "Light Mode"
        } else {
            viewBinding.mode.text = "Dark Mode"
        }
        viewBinding.mode.setOnClickListener {
            if (viewBinding.mode.text.toString() == "Dark Mode") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                modeSharedPreference(AppCompatDelegate.MODE_NIGHT_YES)
            } else if (viewBinding.mode.text.toString() == "Light Mode") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                modeSharedPreference(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun modeSharedPreference(mode : Int)
    {
        sharedPreferences = requireContext().getSharedPreferences("mode",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("modeNow",mode)
        editor.apply()
    }

}