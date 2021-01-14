package com.hassan.android.usastate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hassan.android.usastate.data.getMainResponse
import com.hassan.android.usastate.databinding.FragmentDetailsBinding
import com.hassan.android.usastate.helper.UiHelper
import com.hassan.android.usastate.helper.UiHelper.cropImage
import com.hassan.android.usastate.helper.UiHelper.extractName
import com.hassan.android.usastate.model.Object

const val PERSON_ID = "PERSON_ID"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private lateinit var targetItem: Object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = requireArguments().getInt(PERSON_ID)
        val mainResponse = getMainResponse(requireActivity())
        targetItem = mainResponse.objects.filter { it.person.cspanid == id }[0]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        //load and make images round
        UiHelper.setImageRepublicanOrDemocrats(
            targetItem.party,
            binding.logoImage,
            requireActivity()
        )
        cropImage(binding.messageIcon, R.drawable.message_icon, requireActivity())
        cropImage(binding.callIcon, R.drawable.call_icon, requireActivity())
        cropImage(binding.mailIcon, R.drawable.mail_icon, requireActivity())

        binding.firstLastName.text = extractName(targetItem.person.name)
        binding.bioGuideId.text = targetItem.person.bioguideid
        binding.partyDetails.text = targetItem.party
        binding.personLink.text = targetItem.person.link
        binding.address.text = targetItem.extra.address
        binding.office.text = targetItem.extra.office
        binding.name.text = extractName(targetItem.person.name)
        binding.birthday.text = targetItem.person.birthday
        binding.endDate.text = targetItem.enddate

        //Fix position to make the image in front of card view
        binding.logoImage.elevation = 10F
        binding.cardView.elevation = 5F

        val navController = requireActivity().findNavController(R.id.fragment_host_nav)
        binding.backButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_listFragment)
        }

        return binding.root
    }

}