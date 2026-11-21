package com.steve_md.smartmkulima.ui.fragments.main

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.steve_md.smartmkulima.R
import com.steve_md.smartmkulima.utils.AnalyticsParams
import com.steve_md.smartmkulima.utils.FirebaseAnalyticsHelper
import com.steve_md.smartmkulima.utils.displaySnackBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PayInsuranceModalBottomSheet : BottomSheetDialogFragment() {

    @Inject
    lateinit var analyticsHelper: FirebaseAnalyticsHelper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.modal_bottom_sheet_payment_option,
            container,
            false
        )
    }


//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//
//        dialog?.setOnShowListener { it ->
//            val d = it as BottomSheetDialog
//            val bottomSheet =
//                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
//            bottomSheet?.let {
//                val behavior = BottomSheetBehavior.from(it)
//                behavior.state = BottomSheetBehavior.STATE_EXPANDED
//            }
//        }
//        return super.onCreateDialog(savedInstanceState)
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mpesa = view.findViewById<CardView>(R.id.mpesaCardView)
        val visa = view.findViewById<CardView>(R.id.visaCardView)

        mpesa.setOnClickListener {
            analyticsHelper.logEvent(
                FirebaseAnalytics.Event.ADD_PAYMENT_INFO,
                bundleOf(FirebaseAnalytics.Param.PAYMENT_TYPE to AnalyticsParams.PAYMENT_METHOD_MPESA)
            )
            findNavController().navigate(
                R.id.action_payInsuranceModalBottomSheet_to_paymentFragment
            )
        }
        visa.setOnClickListener {
            displaySnackBar("Payment Method Coming Soon...")
        }
    }
//    override fun getTheme(): Int {
//        return R.style.AppTheme
//    }
}