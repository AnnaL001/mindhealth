package com.anna.mindhealth.ui.patient.profile

import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import com.anna.mindhealth.base.Utility.PATIENT_ROLE
import com.anna.mindhealth.data.`interface`.UserRepo
import com.anna.mindhealth.data.model.Patient
import com.anna.mindhealth.data.model.Therapist
import com.anna.mindhealth.data.repository.UserRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.ktx.Firebase

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepo
    val patientReference: DocumentReference?

    init {
        userRepository = UserRepository(application)
        patientReference = userRepository.read(Firebase.auth.currentUser!!.uid, PATIENT_ROLE)
    }

    fun updatePersonalInfo(patient: Patient, securityLevel: Int, bitmap: Bitmap){
        userRepository.update(patient, securityLevel, bitmap)
    }
}