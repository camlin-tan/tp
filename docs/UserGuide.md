---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# HealthNote User Guide

![HealthNoteLogo](images/HealthNoteLogo.png)

Hello indie doctors, welcome to our **HealthNote User Guide**!

### Table of Contents

<!-- TOC -->
* [HealthNote User Guide](#healthnote-user-guide)
    * [Table of Contents](#table-of-contents)
  * [Introduction](#introduction)
  * [Guide Usage](#guide-usage)
  * [User Interface](#user-interface)
  * [Quick Start](#quick-start)
  * [Features](#features)
    * [Command Format](#command-format)
  * [Features - General Features](#features-general-features)
    * [Viewing help: `help`](#viewing-help-help)
    * [Changing the colour theme: `theme`](#changing-the-colour-theme-theme)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
  * [Features - Managing Patient Records](#features-managing-patient-records)
    * [Adding a patient: `add`](#adding-a-patient-add)
    * [Editing a patient: `edit`](#editing-a-patient-edit)
    * [Deleting a patient: `delete`](#deleting-a-patient)
  * [Features - Viewing Patient Records](#features-viewing-patient-records)
    * [View a patient's medical information: `view`](#view-a-patients-medical-information)
    * [Listing all patients: `list`](#listing-all-patients-list)
    * [Locating patients by name: `find`](#locating-patients-by-name-or-identity)
  * [Features - Managing Appointment Records](#features-managing-appointment-records)
    * [Scheduling an appointment: `schedule`](#scheduling-an-appointment-schedule-)
    * [Deleting upcoming appointment: `unschedule`](#deleting-upcoming-appointment-unschedule)
    * [Delete past appointment: `forget`](#delete-past-appointment-forget)
  * [Features - Clearing Data](#features-clearing-data)
    * [Clearing all entries: `clear`](#clearing-all-entries-clear)
  * [Features - Data Management](#features-data-management)
    * [Saving the data](#saving-the-data)
    * [Editing the data file](#editing-the-data-file)
    * [Archiving data files `[coming in v2.0]`](#archiving-data-files-coming-in-v20)
  * [FAQ](#faq)
  * [Glossary](#glossary)
  * [Known issues](#known-issues)
  * [Command Summary](#command-summary)
    * [Input Constraints Table](#input-constraints-table)
<!-- TOC -->

--------------------------------------------------------------------------------------------------------------------
## Introduction

Are you an independent doctor looking for a simple yet powerful way to manage patient information? Do you find existing clinic management systems too complex or cumbersome for your daily needs? Or perhaps you just want a lightweight, privacy-focused tool that keeps your patients’ records right at your fingertips?

**HealthNote** is your all-in-one, command-line solution for seamless patient management - designed specifically for doctors who value speed, control, and simplicity.

With **HealthNote**, you can easily:
- **Add** new patients and record key details such as contact information, medical history, and allergies
- **View** a patient’s medical information in seconds
- **Find** patients by name or specific keywords
- **Delete** outdated records when necessary
- …and do much more - all directly from your terminal!

Built with independent practitioners and small clinics in mind, **HealthNote** keeps your workflow efficient and focused. Whether you’re managing a handful of patients or maintaining a growing list, this CLI-based address book gives you the precision and speed you need - without unnecessary clutter.

HealthNote is a desktop app for managing contacts, optimized for use via a Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, HealthNote can get your patient management tasks done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------
## Guide Usage

<div markdown="block" class="alert alert-info">

**For Novices**

* For first time users unfamiliar of CLI, perhaps you can first jump to the [Quick Start](#quick-start) section to get started
</div>

<div markdown="block" class="alert alert-success">

**For Amateurs**

* Perhaps you can jump to the [Table of Contents](#table-of-contents) to start navigating the guide.
</div>

<div markdown="block" class="alert alert-warning">

**For Experts**

* Perhaps you can jump to the [Command summary](#command-summary) for a quick summary of the commands.
</div>

--------------------------------------------------------------------------------------------------------------------

## User Interface

Here are the key components of the HealthNote User Interface (UI), designed for the convenience of our users.

![UI-components.png](images/UI-components.png)

| No | Component                                 | Description                                                                                                                          |
|----|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| 1  | Menu bar                                  | Provides access to various actions, such as accessing help or exiting the application.                                               |
| 2  | Command Box                               | This is where the user inputs commands to perform various tasks.                                                                     |
| 3  | Command Result                            | Displays the output and the result of performing a command.                                                                          |
| 4  | Patient List                              | Displays the list of patients.                                                                                                       |
| 5  | Patient's personal information view panel | Displays all the data fields, including medical records, of the patient which the user requests to view.                             |
| 6  | Upcoming and past appointments list panel | Displays all the appointments, with the top list displaying upcoming appointments, and the bottom list displaying past appointments. |
<br>

--------------------------------------------------------------------------------------------------------------------

## Quick Start

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your HealthNote.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui-Updated.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

### Command Format


In this section, we will break down the core components of a command in HealthNote. Understanding these components will help you input commands accurately and efficiently.

The command formats follow a general structure, containing a **command word**, **prefix** and **field**.

| Component        | Example       | Description                                                                                                      |
|------------------|---------------|------------------------------------------------------------------------------------------------------------------|
| **Command Word** | `add`         | Specifies what task or action to perform.                                                                        |
| **Prefix**       | `n\`          | Indicates the specific field to be edited (e.g., name, phone number).                                            |
| **Field**        | `George Best` | Represents the data or value provided by the user, replacing the `UPPER_CASE` placeholder in the command format. |


For example, this is the command format for the `add` command: <br>

![command-format.png](images/command-format.png)

<box type="info" seamless>

**Note**<br>

* Parameters can be in any order.<br>
  e.g. if the command specifies `n\NAME p\PHONE_NUMBER`, `p\PHONE_NUMBER n\NAME` is also acceptable.

</box>

<br>

In the command format, special symbols surrounding prefixes and fields indicate additional properties for the respective fields. Here’s a breakdown:

| **Symbol** | **Description**                                                            | **Example**             | **Interpretation**                               |
|------------|----------------------------------------------------------------------------|-------------------------|--------------------------------------------------|
| **None**   | **Required field**                                                         | `n\NAME`                | The patient's name is required.                  |
| **[ ]**    | **Optional field with a maximum of one entry**                             | `[ar\ALCOHOLIC_RECORD]` | The patient can have at most one alcohol record. |
| **[ ]...** | **Optional field with no limit on the number of entries (including zero)** | `[t\TAG]...`            | The patient can have multiple tags.              |

<box type="info" seamless>

**Example:**

* `n\NAME [t\TAG]` can be used as `n\John Doe t\VIP` or as `n\John Doe`.

* `[t\TAG]…​` can be used as ` ` (i.e. 0 times), `t\VIP`, `t\VIP t\Urgent` etc.

</box>

<br>

<box type="info" seamless>

**More notes about the command formats:**<br>

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list` and `exit`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

* You can view a summary of all the command formats [here](#command-summary).

* You can view a summary of all the fields' input constraints [here](#input-constraints-table).

</box>



--------------------------------------------------------------------------------------------------------------------

## Features - General Features

### Viewing help: `help`

Displays the help window or brings the help window to the front if it is already opened.

![help message](images/HelpWindow-Updated.png)

Format: `help`

<br>

### Changing the colour theme: `theme`

Changes the colour theme of HealthNote.

Format: `theme THEME_NAME`
* Available themes: `light`, `dark`, `blue`, `pink`.
* The theme name **must be exactly one of the available options**.
* Theme names are non-case-sensitive, both lowercase and uppercase letters are accepted.

Examples:
* `theme dark` changes the application to dark mode.
* `theme pink` changes the application to pink mode.

**Here is a list of common errors and how to prevent them**

| Error Message      | Reason                                                             | Solution                                                               |
|--------------------|--------------------------------------------------------------------|------------------------------------------------------------------------|
| Unknown command    | The `theme` command may be misspelled or not entirely in lowercase | Ensure that you use `theme` exactly in lowercase.                      |
| Unknown theme      | The theme name entered is not available                            | Enter one of the available themes: `light`, `dark`, `blue`, or `pink`. |

<br>

### Exiting the program: `exit`

Exits the program.

Format: `exit`

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features - Managing Patient Records

### Adding a patient: `add`

Adds a patient to the address book.

Format: `add n\NAME id\IDENTITY_NUMBER p\PHONE e\EMAIL addr\ADDRESS ec\EMERGENCY_CONTACT dob\DATE_OF_BIRTH b\BLOOD_TYPE 
[ar\ALCOHOLIC_RECORD] g\GENDER [sr\SMOKING_RECORD] [pmh\PAST_MEDICAL_HISTORY] [t\TAG]... [al\ALLERGY]... [m\MEDICINE]...`

| **Field (with Prefix)**      | **Compulsory?** | **Can have multiple?** | **Description**                                                                     | **Constraints**                                                                                 |
| ---------------------------- | --------------- | ---------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| **n\NAME**                   | ✓               | ✗                      | Full legal name of the patient.                                                     | Names can take any values, and it should not be blank                                           |
| **id\IDENTITY_NUMBER**       | ✓               | ✗                      | Unique identification number (e.g., national ID, passport number, or hospital ID).  | Identity number should only contain alphanumeric characters and/or "-", without spaces          |
| **p\PHONE_NUMBER**           | ✓               | ✗                      | Primary phone number for reaching the patient.                                      | Must contain at least 2 consecutive digits                                                      |
| **e\EMAIL**                  | ✓               | ✗                      | Patient’s active email address for communication.                                   | Emails should be of the format local-part@domain                                                |
| **addr\HOME_ADDRESS**        | ✓               | ✗                      | Current residential address of the patient.                                         | Addresses can take any values, and it should not be blank                                       |
| **ec\EMERGENCY_CONTACT**     | ✓               | ✗                      | Name and contact details of a patient to call in case of emergency.                 | Must be in the form [{relationship}] {phone} where phone contains at least 2 consecutive digits |
| **dob\DATE_OF_BIRTH**        | ✓               | ✗                      | Patient’s date of birth.                                                            | Date of birth should be of the following formats: d-m-yyyy, d.m.yyyy, d/m/yyyy                  |
| **b\BLOOD_TYPE**             | ✓               | ✗                      | Patient’s blood group (e.g., A+, O-, etc.).                                         | Blood types can take any values, and it should not be blank                                     |
| **g\GENDER**                 | ✓               | ✗                      | Gender identity of the patient (e.g., Male, Female, Non-binary, Prefer not to say). | Genders can take any values, and it should not be blank                                         |
| **ar\ALCOHOLIC_RECORD**      | ✗               | ✗                      | Indicates whether the patient consumes alcohol and relevant details or frequency.   | Alcoholic Record can take any values, and it should not be blank                                |
| **sr\SMOKING_RECORD**        | ✗               | ✗                      | Indicates whether the patient smokes and relevant details or frequency.             | Smoking Record can take any values, and it should not be blank                                  |
| **pmh\PAST_MEDICAL_HISTORY** | ✗               | ✗                      | Summary of major past illnesses, surgeries, or chronic conditions.                  | Past Medical History can take any values, and it should not be blank                            |
| **t\TAG**                    | ✗               | ✓                      | Custom labels or categories for organising patients.                                | Tags names can take any values, and it should not be blank                                      |
| **al\ALLERGY**               | ✗               | ✓                      | List of known allergies (e.g., “Peanuts”, “Penicillin”).                            | Allergy names can take any values, and it should not be blank                                   |
| **m\MEDICINE**               | ✗               | ✓                      | List of current medications prescribed to the patient.                              | Medicine field can take any values, and it should not be blank                                  |


<div markdown="block" class="alert alert-info">

**ℹ️ Info:**<br>
* When adding patients without using the optional fields `ALCOHOLIC_RECORD`, `SMOKING_RECORD` and `PAST_MEDICAL_HISTORY`, they will have default values "None" for these fields . 
* You can enter any number of tags, allergies, medicines (including 0).
</div>

<box type="tip" seamless>

**Tip:** The fields can be entered in any order.
</box>

Examples:
* `add n\John Doe id\A91234567 p\98765432 e\johnd@example.com addr\311, Clementi Ave 2, #02-25 ec\[Mother] +6591234567
 b\AB ar\Social drinker g\M dob\01-01-2000 sr\Heavy smoker al\nuts t\priorityHigh t\diabetesFollowUp pmh\Diabetes
 m\100mg painkillers/day m\100mg Panadol/day`

* `add n\John Doe id\A91234567 p\98765432 e\johnd@example.com addr\311, Clementi Ave 2, #02-25 ec\[Mother] +6591234567
  b\AB ar\Social drinker g\M dob\01-01-2000`

**Here is a list of common errors and how to prevent them**

| Error Message                                  | Reason                                                           | Solution                                                             |
|------------------------------------------------|------------------------------------------------------------------|----------------------------------------------------------------------|
| The patient already exists in the address book | You are adding a patient with the same id as an existing patient | Ensure that you do not enter a patient with the same id as an existing patient. |
| Invalid command format!                        | Some of the essential prefixes could be missing or misspelled    | Refer to the [command format](#adding-a-patient-add)                 |
| Unknown command                                | The `add` command may be misspelled or not entirely in lowercase | Ensure that you use `add` exactly in lowercase.                      |
| Errors relating to invalid field inputs        | You have entered invalid inputs for a field.                     | Ensure that your inputs meet the constraints stated in the [Input Constraints Table](#input-constraints-table)          |


[Back to Table of Contents](#table-of-contents)

<br>

### Editing a patient: `edit`

Edits an existing patient in the address book.

Format: `edit INDEX [n\NAME] [id\IDENTITY_NUMBER] [p\PHONE] [e\EMAIL] [addr\ADDRESS]
 [ec\EMERGENCY_CONTACT] [dob\DATE_OF_BIRTH] [b\BLOOD_TYPE] [ar\ALCOHOLIC_RECORD] [g\GENDER] [sr\SMOKING_RECORD] 
 [pmh\PAST_MEDICAL_HISTORY] [t\TAG]... [al\ALLERGY]... [m\MEDICINE]...`

* Edits the patient at the specified `INDEX`. 
* The index refers to the index number shown in the displayed patient list. 
* The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e. adding of tags is not cumulative. This applies to medicines and allergies as well. <br>
  e.g. If a patient at `INDEX` 3 has the allergies "nuts" and "eggs", performing `edit 3 al\Penicillin` will replace all that patient's allergies with "Penicillin" only.

<div markdown="block" class="alert alert-info">

**ℹ️ Info:**<br> 
* You can remove all the patient’s tags by typing `t\` without
  specifying any tags after it.
* You can remove all the patient’s medicine record by typing `m\` without
  specifying any medicines after it.
* You can remove all the patient’s allergies by typing `al\` without
  specifying any allergies after it.
* Typing `pmh\` without specifying any past medical history after it will 
cause it the patient's past medical history to default to the value "None". <br>
  The same applies to `ar\`, `sr\` for alcoholic and smoking record respectively.
</div>

| **Field (with Prefix)**      | **Compulsory?** | **Can have multiple?** | **Description**                                                                     | **Constraints**                                                                                 |
| ---------------------------- | --------------- | ---------------------- | ----------------------------------------------------------------------------------- |-------------------------------------------------------------------------------------------------|
| **INDEX**                    | ✓               | ✗                      | Index of the patient in the Patient List Panel.                                     | Must be a positive number and valid INDEX in the patient list.                                  |
| **n\NAME**                   | ✗               | ✗                      | Full legal name of the patient.                                                     | Names can take any values, and it should not be blank                                           |
| **id\IDENTITY_NUMBER**       | ✗               | ✗                      | Identification number (e.g., national ID, passport number, or hospital ID).         | Identity number should only contain alphanumeric characters and/or "-", without spaces          |
| **p\PHONE_NUMBER**           | ✗               | ✗                      | Primary phone number for reaching the patient.                                      | Must contain at least 2 consecutive digits                                                      |
| **e\EMAIL**                  | ✗               | ✗                      | Patient’s email address for communication.                                          | Emails should be of the format local-part@domain                                                |
| **addr\HOME_ADDRESS**        | ✗               | ✗                      | Current residential address of the patient.                                         | Addresses can take any values, and it should not be blank                                       |
| **ec\EMERGENCY_CONTACT**     | ✗               | ✗                      | Name and contact details of a patient to contact in case of emergency.              | Must be in the form [{relationship}] {phone} where phone contains at least 2 consecutive digits |
| **dob\DATE_OF_BIRTH**        | ✗               | ✗                      | Patient’s date of birth.                                                            | Date of birth should be of the following formats: d-m-yyyy, d.m.yyyy, d/m/yyyy                  |
| **b\BLOOD_TYPE**             | ✗               | ✗                      | Patient’s blood group (e.g., A+, O-, etc.).                                         | Blood types can take any values, and it should not be blank                                     |
| **g\GENDER**                 | ✗               | ✗                      | Gender identity of the patient (e.g., Male, Female, Non-binary, Prefer not to say). | Genders can take any values, and it should not be blank                                         |
| **ar\ALCOHOLIC_RECORD**      | ✗               | ✗                      | Indicates whether the patient consumes alcohol and relevant details or frequency.   | Alcoholic Record can take any values, and it should not be blank                                |
| **sr\SMOKING_RECORD**        | ✗               | ✗                      | Indicates whether the patient smokes and relevant details or frequency.             | Smoking Record can take any values, and it should not be blank                                  |
| **pmh\PAST_MEDICAL_HISTORY** | ✗               | ✗                      | Summary of major past illnesses, surgeries, or chronic conditions.                  | Past Medical History can take any values, and it should not be blank                            |
| **t\TAG**                    | ✗               | ✓                      | Custom labels or categories for organising patients.                                | Tags names can take any values, and it should not be blank                                      |
| **al\ALLERGY**               | ✗               | ✓                      | List of known allergies (e.g., “Peanuts”, “Penicillin”).                            | Allergy names can take any values, and it should not be blank                                   |
| **m\MEDICINE**               | ✗               | ✓                      | List of current medications prescribed to the patient.                              | Medicine field can take any values, and it should not be blank                                  |


Examples:
*  `edit 1 p\91234567 e\johndoe@example.com` Edits the phone number and email address of the 1st patient to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n\Betsy Crower t\` Edits the name of the 2nd patient to be `Betsy Crower` and clears all existing tags.

**Here is a list of common errors and how to prevent them**

| Error Message                                  | Reason                                                                                    | Solution                                                                                                      |
|------------------------------------------------|-------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| The patient already exists in the address book | You are editing a patient to have the same id as an existing patient                      | Ensure that you do not enter a patient with the same id as an existing patient.                               |
| Invalid command format!                        | Some of the prefixes could be missing or misspelled, or you entered a non-positive index. | Refer to the [command format](#editing-a-patient-edit)                                                        |
| Unknown command                                | The `edit` command may be misspelled or not entirely in lowercase                         | Ensure that you use `edit` exactly in lowercase.                                                              |
| Errors relating to invalid field inputs        | You have entered invalid inputs for a field.                                              | Ensure that your inputs meet the constraints stated in the [Input Constraints Table](#input-constraints-table) |
| The patient index provided is invalid          | You have entered an invalid index                                                         | Ensure that the index not more than the number of patients in HealthNote.                                     |
| At least one field to edit must be provided.   | You have not entered any fields to edit.                                                  | Enter at least one field to edit.                                                                             |


[Back to Table of Contents](#table-of-contents)

### Deleting a patient:

Purpose: Removes the specified patient from the patient list.

Command: `delete`

Usage: Type `delete` followed by the index number of the patient to be removed.

Format: `delete INDEX`

<div markdown="block" class="alert alert-info">

**ℹ️ Info:**<br>
* Deletes the patient at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the currently displayed patient list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …​ , and should not exceed the number of patients in the currently displayed list.
</div>

Examples:
* `list` followed by `delete 2` deletes the 2nd patient in the full patient list.
* `find Betsy` followed by `delete 1` deletes the 1st patient in the results of the `find` command.

**Here is a list of common errors and how to prevent them**

| Error Message                        | Reason                                                                                         | Solution                                                                                     |
|--------------------------------------|------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| Invalid command format!              | You did not specify an `INDEX` or the `INDEX` provided is not positive.                        | Enter a positive integer as `INDEX`.                                                           |
| Unknown command                      | The `delete` command may have been misspelled or not entered in lowercase.                     | Ensure that you use `delete` exactly in lowercase.                                           |
| The person index provided is invalid | You have entered an `INDEX` that exceeds the number of patients in the currently displayed list. | Ensure that the `INDEX` not more than the number of patients in the currently displayed list. |


[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features - Viewing Patient Records

### View a patient's medical information:

Purpose: Displays the medical information of the patient at the specified `INDEX`.

Command: `view`

Usage: Type `view` followed by the index number of the patient whose medical information you want to see.

Format: `view INDEX`

<div markdown="block" class="alert alert-info">

**ℹ️ Info:**<br>
* Displays the patient at the specified `INDEX` on the view panel.
* The index refers to the index number shown in the currently displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​ , and should not exceed the number of patients in the currently displayed list.
</div>

Example:
- `list` followed by `view 1` displays the medical information of the 1st patient in the full patient list on the view panel.
- `find Betsy` followed by `view 2` displays the medical information of the 2nd patient in the results of the `find` command on the view panel.

**Here is a list of common errors and how to prevent them:**

| Error Message                        | Reason                                                                                         | Solution                                                                                              |
|--------------------------------------|------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| Invalid command format!              | You did not specify an `INDEX` or the `INDEX` provided is not positive.                            | Enter a positive integer as `INDEX`.                                                                  |
| Unknown command                      | The `view` command may have been misspelled or not entered in lowercase                      | Ensure that you use `view` exactly in lowercase.                                                      |
| The person index provided is invalid | You have entered an `INDEX` that exceeds the number of patients in the currently displayed list. | Ensure that the entered `INDEX` not more than the number of patients in the currently displayed list. |

### Listing all patients:

Purpose: Shows a list of all patients stored in the patient list.

Command: `list`

Usage: Type `list` to display all patients.

Format: `list`

<div markdown="block" class="alert alert-info">

**ℹ️ Info:**<br>

* The list will be refreshed to show all patients when the `list` command is used.
* Patients are displayed in the order they were added, with the most recently added patients appearing at the end of the list.
</div>

<box type="tip" seamless>

**Tip:** You can use the `list` command to reset the patient list view after using the `find` command.
</box>

Examples:
- `list` displays all patients in the patient list.<br>
- `list 123` will displays same as `list` with the below warning message.<br>
  `Note: Additional arguments detected. You may provide extra arguments, but they will be ignored.`

[Back to Table of Contents](#table-of-contents)


### Locating patients by name or identity:

Purpose: Search for patients in the patient list by name or identity number.

Command: `find`

Usage: Type `find` followed by at least one keyword.

Format: `find KEYWORD [MORE_KEYWORDS]`

<div markdown="block" class="alert alert-info">

**ℹ️ Matching criteria:**<br>
* **Case-insensitive** for both name and identity. <br>
  Example: `hans` matches `Hans`, `a1234567X` matches `A1234567x`
* **Name** matches if any of the keywords is part of the patient's name.<br>
  Example: keyword `Hans` matches patient with name `Hans Andersen` and `Joanne Hans`, but not `JHans Doe`
* **Identity** matches if any of the keywords matches exactly the patient's identity.<br>
  Example: keyword `S1234567A` matches patient with identity `s1234567a` but not `S12345678A`
* **Inclusive search**: <br>
  A patient is listed if any of the keywords match either the patient's name or identity.
</div>

<box type="tip" seamless>

**Tip:** The fields can be entered in any order. <br>
  e.g. `find John Alex` returns the same results as `find Alex John`<br>
</box>

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavid-Updated.png) 

**Here is a list of common errors and how to prevent them**

| Error Message                                 | Reason                                                            | Solution                                         |
|-----------------------------------------------|-------------------------------------------------------------------|--------------------------------------------------|
| Invalid command format!                       | You may not have provided any keyword                             | Add at least one keyword, e.g. `John`.           |
| Unknown command                               | The `find` command may be misspelled or not entirely in lowercase | Ensure that you use `find` exactly in lowercase. |

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features - Managing Appointment Records

### Scheduling an appointment: `schedule` 

Adds the appointment for the patient identified by the index number used in the displayed patient list.

Format: `schedule INDEX adt\APPOINTMENT_TIME [note\APPOINTMENT_NOTE]`

* Adds an appointment the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed **patient** list.
* The index **must be a positive integer** 1, 2, 3, …​
* Note that APPOINTMENT_NOTE is optional

Example:
* `schedule 1 adt\13-10-2025 10:00 note\Needs IV Drip`

### Deleting upcoming appointment: `unschedule`

Deletes the upcoming appointment identified by the index number used in the displayed upcoming appointment list.

Format: `unschedule INDEX`

* Deletes the upcoming appointment at the specified `INDEX`.
* The index refers to the index number shown in the displayed **Upcoming Appointments** list.
* The index **must be a positive integer** 1, 2, 3, …​

Example:
* `unschedule 1`

### Delete past appointment: `forget`

Deletes the past appointment identified by the index number used in the displayed past appointment list.

Format: `forget INDEX`

* Deletes the past appointment at the specified `INDEX`.
* The index refers to the index number shown in the displayed **Past Appointments** list.
* The index **must be a positive integer** 1, 2, 3, …​

Example:
* `forget 1`

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features - Clearing Data

### Clearing all entries: `clear`

Clears all entries from the app.

Format: `clear CONFIRM`

<div markdown="block" class="alert alert-danger">

**❗Warning:**<br>
* This action cannot be undone. You must type exactly 'clear CONFIRM' (case-sensitive) to execute
</div>

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features - Data Management

### Saving the data

HealthNote data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

HealthNote data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**❗Caution:**
If your changes to the data file makes its format invalid, HealthNote will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the HealthNote to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous HealthNote home folder.

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Glossary

| **Term**                     | **Explanation**                            |
|------------------------------|--------------------------------------------|
| Alphanumeric                 | Consists of numbers and/or alphabets only. |
| CLI (Command-Line Interface) |        A text-based interface where you type commands to interact with the app.                                    |
| Command                      |  An instruction entered by the user (e.g., `add`, `edit`, `delete`).                                          |
| Field                        |   A specific piece of information in a patient’s record (e.g., name, address, blood type).                                         |
| Prefix                       |   A short label before a field to identify it in a command (e.g., `n\` for name, `p\` for phone).                                         |
| Index                        |   The number showing a patient’s position in the displayed list. Used in commands like `edit` or `delete`.                                                                                                                                        |
|        Integer                      |     A whole number (no decimals). In HealthNote, indexes must be positive integers such as 1, 2, 3, etc.                                                                                                                                                                                                                                              |
|               GUI (Graphical User Interface)                      |         The visual interface showing panels, buttons, and text boxes.                                                                                                                                                                                                                                                                                                                                              |

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will be focused, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Command Summary

Summary of all the commands.

<box type="info" seamless>

**Info:**<br>
* Fields with square brackets `[prefix\field]` indicates it is an optional field.
* Fields with square brackets and ellipsis `[prefix\field]...` indicates it is an optional field which can be entered multiple times.
* Commands without any arguments will still execute if user inputs additional arguments
* You may view [Command Format](#command-format) for more details.

</box>


| Action                        | Format, Examples                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
|-------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**                       | `add n\NAME id\IDENTITY_NUMBER p\PHONE_NUMBER e\EMAIL addr\ADDRESS ec\EMERGENCY_CONTACT dob\DATE_OF_BIRTH b\BLOOD_TYPE [ar\ALCOHOLIC_RECORD] g\GENDER [sr\SMOKING_RECORD] [pmh\PAST_MEDICAL_HISTORY] [t\TAG]... [al\ALLERGY]... [m\MEDICINE]...` <br> e.g., `add n\John Doe id\A91234567 p\98765432 e\johnd@example.com addr\311, Clementi Ave 2, #02-25 ec\[Mother] +6591234567 b\AB ar\Social drinker g\M dob\01-01-2000 sr\Heavy smoker al\nuts t\priorityHigh t\diabetesFollowUp pmh\Diabetes m\100mg painkillers/day m\100mg Panadol/day` |
| **Clear**                     | `clear CONFIRM`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **Delete**                    | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| **Edit**                      | `edit INDEX [n\NAME] [id\IDENTITY_NUMBER] [p\PHONE_NUMBER] [e\EMAIL] [addr\ADDRESS] [ec\EMERGENCY_CONTACT] [dob\DATE_OF_BIRTH] [b\BLOOD_TYPE] [ar\ALCOHOLIC_RECORD] [g\GENDER] [sr\SMOKING_RECORD] [pmh\PAST_MEDICAL_HISTORY] [t\TAG]... [al\ALLERGY]... [m\MEDICINE]...`<br> e.g.,`edit 2 n\James Lee e\jameslee@example.com`                                                                                                                                                                                                               |
| **Find**                      | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| **List**                      | `list`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **View**                      | `view INDEX`<br> e.g., `view 1`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **Help**                      | `help`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **Schedule an Appointment**   | `schedule INDEX adt\APPOINTMENT_DATE_TIME [note\APPOINTMENT_NOTE]`<br> e.g., `schedule 1 adt\13-10-2025 10:00 note\Needs IV Drip`                                                                                                                                                                                                                                                                                                                                                                                                            |
| **Unschedule an appointment** | `unschedule INDEX`   <br> e.g., `unschedule 1`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **Remove a Past Appointment** | `forget INDEX`  <br> e.g., `forget 1`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |

[Back to Table of Contents](#table-of-contents)

### Input Constraints Table

<div markdown="block" class="alert alert-warning">

**❗Caution:**

* The symbol is `\` is reserved as a command delimiter. While it is not explicitly prohibited in command values, it is
  highly discouraged as it could cause unexpected behaviour.

</div>

| **Field (with Prefix)**        | **Valid Input(s)**                                      | **Invalid Input(s)**           | **Requirement(s)**                                                                                            |
|--------------------------------|---------------------------------------------------------|--------------------------------|---------------------------------------------------------------------------------------------------------------|
| **n\\NAME**                    | Alex the 3rd, John Doe, Damith s/o Sankar Ashish        | (Empty)                        | Names can take any values, and it should not be blank                                                         |
| **id\\IDENTITY_NUMBER**        | S1234567A, T7654321B, 060402-06-6767                    | %&!, 12 3-4                    | Identity number should only contain alphanumeric characters and/or "-", without spaces                        |
| **p\\PHONE_NUMBER**            | 9888-3333 (Office)                                      | abcdefg, 3 3 3                 | Must contain at least 2 consecutive digits                                                                    |
| **e\\EMAIL**                   | e01234567@u.nus.edu, jinHeng@gmail.com                  | joe@, asd@@@asd                | Emails should be of the format local-part@domain                                                              |
| **addr\\HOME_ADDRESS**         | 123 Main St                                             | (Empty)                        | Addresses can take any values, and it should not be blank                                                     |
| **ec\\EMERGENCY_CONTACT**      | [Mother] 9888-3333 (Office), [Brother] 9777-3333 (Home) | 9888-3333, 2222aaaa            | Must be in the form [{relationship}] {phone} where phone contains at least 2 consecutive digits               |
| **dob\\DATE_OF_BIRTH**         | 05-23-1967, 12/10/1987                                  | 99-05-23, 19871312, 2020-12-20 | Date of birth should be of the following formats: d-m-yyyy, d.m.yyyy, d/m/yyyy                                |
| **b\\BLOOD_TYPE**              | A+, O-, AB, Bombay (hh), A Rh(D) negative               | (Empty)                        | Blood types can take any values, and it should not be blank                                                   |
| **g\\GENDER**                  | Male, Female, Non-binary, Genderqueer                   | (Empty)                        | Genders can take any values, and it should not be blank                                                       |
| **ar\\ALCOHOLIC_RECORD**       | None, Occasionally, Heavy                               | (Empty)                        | Alcoholic Record can take any values, and it should not be blank                                              |
| **sr\\SMOKING_RECORD**         | None, Occasionally, Quitter, Heavy                      | (Empty)                        | Smoking Record can take any values, and it should not be blank                                                |
| **pmh\\PAST_MEDICAL_HISTORY**  | None, Diabetes, Hypertension                            | (Empty)                        | Past Medical History can take any values, and it should not be blank                                          |
| **t\\TAG**                     | Urgent, HighRisk, VIP                                   | (Empty)                        | Tags names can take any values, and it should not be blank                                                    |
| **al\\ALLERGY**                | Peanuts, Penicillin                                     | (Empty)                        | Allergy names can take any values, and it should not be blank                                                 |
| **m\\MEDICINE**                | 500mg Ibuprofen, 2 Panadol capsules/day                 | (Empty)                        | Medicine field can take any values, and it should not be blank                                                |
| **adt\\APPOINTMENT_DATE_TIME** | 13-10-2025 10:00                                        | 22233344                       | Appointment date & time should be of the following formats: d-m-yyyy HH:mm, d.m.yyyy HH:mm, or d/m/yyyy HH:mm |
| **note\\APPOINTMENT_NOTE**     | Needs IV Drip                                           | (Empty)                        | Appointment notes can take any values, and it should not be blank                                             |

[Back to Table of Contents](#table-of-contents)
