import com.xnical.combigo.data.dataSource.local.entity.PatientEntity
import com.xnical.combigo.domain.model.Patient

fun PatientEntity.toPatient(): Patient {
    return Patient(
        id = id,
        name = name,
        description = description,
        image1 = image1,
        image2 = image2,
        weight = weight,
        age = age,
        idClinic = idClinic,
        imagesToUpdate = null
    )
}

fun Patient.toPatientEntity(): PatientEntity {
    return PatientEntity(
        id = id ?: "",
        name = name,
        description = description,
        image1 = image1 ?: "",
        image2 = image2 ?: "",
        weight = weight,
        age = age,
        idClinic = idClinic
    )
}