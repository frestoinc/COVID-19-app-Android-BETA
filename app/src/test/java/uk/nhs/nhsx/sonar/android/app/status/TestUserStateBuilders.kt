package uk.nhs.nhsx.sonar.android.app.status

import org.joda.time.DateTime
import uk.nhs.nhsx.sonar.android.app.util.NonEmptySet
import uk.nhs.nhsx.sonar.android.app.util.nonEmptySetOf

fun buildAmberState(
    until: DateTime = DateTime.now().plusDays(1)
) = AmberState(until)

fun buildRedState(
    until: DateTime = DateTime.now().plusDays(1),
    symptoms: NonEmptySet<Symptom> = nonEmptySetOf(Symptom.COUGH)
) = RedState(until, symptoms)

fun buildCheckinState(
    until: DateTime = DateTime.now().plusDays(1),
    symptoms: NonEmptySet<Symptom> = nonEmptySetOf(Symptom.COUGH)
) = CheckinState(until, symptoms)
