package com.hassan.android.usastate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.hassan.android.usastate.databinding.FragmentDetailsBinding
import com.hassan.android.usastate.model.Object

const val PERSON_ID = "PERSON_ID"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private lateinit var targetItem: Object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = requireArguments().getInt(PERSON_ID)
        Log.d("TEST", "id = $id")
        val mainResponse = getMainResponse(requireActivity())
        targetItem = mainResponse.objects.filter { it.person.cspanid == id }[0]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        //load and make images round
        Glide.with(requireActivity())
            .load(R.drawable.mail_icon)
            .circleCrop()
            .into(binding.mailIcon)

        Glide.with(requireActivity())
            .load(R.drawable.call_icon)
            .circleCrop()
            .into(binding.callIcon)

        Glide.with(requireActivity())
            .load(R.drawable.message_icon)
            .circleCrop()
            .into(binding.messageIcon)

        if (targetItem.party == "Republican") {
            Glide.with(requireActivity())
                .load(R.drawable.republicans)
                .circleCrop()
                .into(binding.logoImage)
        } else {
            Glide.with(requireActivity())
                .load(R.drawable.democrats)
                .circleCrop()
                .into(binding.logoImage)
        }

        //Fix position to make the image in front of card view
        binding.logoImage.elevation = 10F
        binding.cardView.elevation = 5F

        binding.firstLastName.text =
            targetItem.person.name.substring(5, targetItem.person.name.indexOf('['))

        binding.bioGuideId.text = targetItem.person.bioguideid
        binding.partyDetails.text = targetItem.party
        binding.personLink.text = targetItem.person.link
        val navController = requireActivity().findNavController(R.id.fragment_host_nav)
        binding.backButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_listFragment)
        }
        binding.address.text = targetItem.extra.address
        binding.office.text = targetItem.extra.office
        binding.name.text = targetItem.person.name.substring(5, targetItem.person.name.indexOf('['))
        binding.birthday.text = targetItem.person.birthday
        binding.endDate.text = targetItem.enddate

        return binding.root
    }

}