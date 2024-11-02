package com.example.project_hostel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project_hostel.databinding.FragmentFragmentBinding
import java.util.*

class RoutineFragment : Fragment() {

    private var _binding: FragmentFragmentBinding? = null
    private val binding get() = _binding!!

    // Map containing routines for each day of the week
    private val routines = mapOf(
        Calendar.MONDAY to "                    Monday Routine: \n\n 1. Breakfast: Bread Butter+Jam+Corn Flakes+Boiled Egg+Tea+Milk+Sauce\n\n 2. Lunch: Rajma+Aloo Shimla Mirch+Roti+Plain Rice+bundi Raita+Salad+Pickle\n\n 3. Snacks: French Fries+Sauce+Tea\n\n 4. Dinner: Matar Poneer/Kadhai Paneer(Alternatively)+Mix Veg+Roti+Jeera rice+salad+Pickle",
        Calendar.TUESDAY to "                   Tuesday Routine: \n\n 1. Breakfast: Pav Bhaji/Chole kulche+Tea+Milk+Sauce\n\n 2. Lunch: Kala Chana(gravy)+Aloo Pyaz Bujiya+Roti+Jeera Rice+Veg Raita+Salad+Pickle\n\n 3. Snacks: Samosa+Chhole+Meethi Chutney+Green Chutney+Tea\n\n 4. Dinner: Moong dal+Dry kathal/bhindi+Roti+Rice+Salad+Pickle+Gulab Jamun/Sponge Rasgulla(Alternate Day)",
        Calendar.WEDNESDAY to "                 Wednesday Routine: \n\n1. Breakfast: Veg Cutlet+Bread Butter+Boiled Egg+Tea+Milk+Sauce\n\n 2. Lunch: Kaali Urad+Chana dal+Aloo Soyabeen/Lauki chana dal+Roti+Rice+Salad+Plane Dahi+Pickle\n\n 3. Snacks:Veg Pasta+Sauce/Bread Pakoda+Meethi Chutney+Green Chutney+Tea\n\n 4. Dinner: Puri+Pindi Chole+Petha Sabji+Jeera Rice+Salad+Pickle",
        Calendar.THURSDAY to "                   Thursday Routine: \n\n 1. Breakfast: [Stuffed puri+Aloo Sabji gravy]/[Suji Halwa+Kala chana] +Tea+Milk\n\n 2. Lunch:Kadhi Pakoda+Jeera Aloo+Roti+Rice+Salad+Pickle\n\n 3. Snacks: Burger with mayonnaise Sauce+Sauce+Tea\n\n 4. Dinner: Rajma+Mix Veg+Roti+Rice+Salad+Pickle+Ice-cream",
        Calendar.FRIDAY to "                   Friday Routine: \n\n 1. Breakfast: Poha+Daliya+Sauce+Tea\n\n 2. Lunch: Arhar dal(fry)+Bengan Bharta+Fruit Raita+Roti+Rice+Salad+Pickle\n\n 3. Snacks: Aloo Tikki+Boiled Matar Masala+Meethi Chutney+Green Chutney+Tea\n\n 4. Dinner: Shahi Panner/Panner Do Pyaza (Alternatively)+Egg curry+Aloo Beans+Roti+Rice+Salad+Pickle",
        Calendar.SATURDAY to "                  Saturday Routine: \n\n 1. Breakfast: Aloo pyaaz pranthe/Mix Pranthe+Achaar+Sauce+Tea+Plain Dahi/Sweet Lassi\n\n 2. Lunch: Veg Biryani+Papad+Green Chutne+Salad+Bundi Raita+Pickle\n\n 3. Snacks: Aloo Sandwich+Sauce/Fried Idli+Nariyal Chutney+Tea\n\n 4. Dinner: Arhar Dal+Dry Seasonal Vegetable(Cabbage/Parwal/Kundra/ Beans/Karela)+Roti+Veg Pulao+Salad+Pickle+Custard/seviyaan",
        Calendar.SUNDAY to "                   Sunday Routine: \n\n 1. Breakfast: [Idli+Sambhar+Nariyal Chutney/Plain Parantha+Aloo Tamatar Sabji]+Tea+Milk \n\n 2. Lunch: Chhule Bhature+Jeera Rice+Fried Aloo+Plain Curd+Sugar+Fried Mirchi+Salad+Pickle\n\n 3. Snacks: Chowmin+Sauce+Tea\n\n 4. Dinner: Dal makhni/Lal Malka Masoor Dal+Aloo tamatar(Gravy)+Roti+Fried Rice+mix salad+Pickle",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragmentBinding.inflate(inflater, container, false)

        // Get the current day of the week
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // Set the routine based on the current day
        val routine = routines[dayOfWeek] ?: "No routine found for today."
        binding.tvRoutine.text = routine

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}