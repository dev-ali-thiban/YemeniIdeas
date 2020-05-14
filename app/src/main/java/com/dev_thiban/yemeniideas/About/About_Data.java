package com.dev_thiban.yemeniideas.About;

import com.dev_thiban.yemeniideas.R;

import java.util.ArrayList;
import java.util.List;

public class About_Data {

    public static List<About_Model> about_list (String spe){

        String name[] = {
                "علي ذيبان",
                "هيام الجبلي",
                "ابراهيم صادق",
                "علواء المقطري",
                "عنتر الكامل",
                "طارق ذياب",
                "یزن حسن",
                "محمد",
                "عارف",
                "زيد السبل",
                "مارينا الوائلي",
                "علي صواب",
                "احمد",
                "بشرى الضوراني",
                "خلدون الاصبحي",
                "رشيد علي",
                "عصام باحبیل",
                "علاء مھیوب",
                "يعقوب رزاز",
                "اسام سنان",
                "موسى علآو",
                "جهاد الحمیري",
                "ابراهيم",
                "رامي",
                "صادق قائد"
        };
        String grop[] = {
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "التقنية",
                "طب",
                "طب",
                "طب",
                "طب",
                "طب",
                "طب",
                "طب",
                "طب",
                "هندسة",
                "هندسة",
                "هندسة",
                "التنفيذ والادارة المدانية",
                "التنفيذ والادارة المدانية",
                "التنفيذ والادارة المدانية",
                "التنفيذ والادارة المدانية"
        };

        int img[] = {
                R.drawable.user_img_my,
                R.drawable.user_women,
                R.drawable.user_man,
                R.drawable.user_women,
                R.drawable.user_img_5,
                R.drawable.user_man,
                R.drawable.user_img_7,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_img_14,
                R.drawable.user_man,
                R.drawable.user_img_13,
                R.drawable.user_img_14,
                R.drawable.user_img_15,
                R.drawable.user_img_16,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_img_19,
                R.drawable.user_img_20,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_man,
                R.drawable.user_man
        };
        String about[] = {
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "مارينا طالبة في جامعة سبأ تخصص طب اسنان ، عملت في مهنة التدريس سابقا ، مصورة مبتدئة ، شغوفة ولي حس في مجال تصميم الديكورات ، امتلك اللغة الانجليزية بمستوى جيد جدا ولي العديد من الشهادات لدورات في مجال التنمية البشرية وغيرها .",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "التخصص : طب بشري \n \n - تخرجت من كلية الطب جامعة ذمار لعام ( 2016 - 2015 ) . \n - عضو جمعية بذرة خير الطلابية . \n - عضو جمعية الغيث يبدأ بعشره الخيرية. \n - عضو الجمعية الامريكية للميكروبيولوجي وشاركت في العديد من الدورات الطبيه والاحصائيه والوبائيه التابعه لها . \n - حاصلة على العديد من الجوائز الثقافيه في مجال الكتابه .\n - عضو منظمة العفو الدوليه .\n",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "مهندس ميكاترونكس وروبوتات وهتم بالذكاء الاصطناعي في مجال الروبوتات وبتطوير انظمة التحكم ، اطمح الى مواصلة الدراسات العليا في مجال الذكاء الاصطناعي والروبوتات لتقديم رؤية واضحة وجديد عن الروبوتات الذكية ، باحث في مجال الروبوتات التعاونية عبر استخدام تقنيات متعددة.",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات",
                "لا توجد اي معلومات"
        };

        List<About_Model> about_lists = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            About_Model post = new About_Model();
            post.setName(name[i]);
            post.setGrop(grop[i]);
            post.setImg(img[i]);
            post.setAbout(about[i]);
            about_lists.add(post);
        }


        return searchResult(about_lists,spe) ;
    }

    private static List<About_Model> searchResult(List<About_Model> mobileList, String query) {
        List<About_Model> tempList = new ArrayList<>();
        for (int i = 0; i < mobileList.size(); i++) {
            String mobileName = mobileList.get(i).getGrop();
            if (mobileName.compareTo(query) == 0)
                tempList.add(mobileList.get(i));
        }
        return tempList;
    }

}
