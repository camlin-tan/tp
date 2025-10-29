# Available Commands

## Add a patient: `add`
Adds a patient with the specified fields
#### Patient fields
##### Must contain:
- Name: `n\`
- Identity Number: `id\`
- Date of Birth: `dob\`
- Contact Number: `p\`
- Email: `e\`
- Home Address: `a\`
- Emergency Contact: `ec\`
- Blood Type: `b\`
- Gender: `g\`
- Alcoholic Record: `ar\`

##### Optional, single entry:
- Smoking Record: `sr\`
- Past Medical History: `pmh\`

##### Optional, can have multiple:
- Tags: `t\`
- Allergies: `al\`
- Medicines: `m\`;

#### Example:
```
add n\Betsy Crowe id\BC67 dob\02-02-2000 p\+65 12345678 e\betsycrowe@example.com a\67 Yishun Street ec\[mother] +60 12-123-4567 b\AB g\Female ar\NO sr\NO t\Yishun t\HighPriority al\Pollen al\Nuts m\Amlodepine m\Bisoprolol
```


## Delete a patient: `delete`

Deletes the person at the specified INDEX

Format: `delete <INDEX>`

Example: `delete 1`

## View a patient's medical information: `view`

Displays the medical information of the patient at the specified INDEX

Format: `view <INDEX>`

Example: `view 1`

## List all patients: `list`
## Find patients by name: `find KEYWORD [MORE_KEYWORDS]`
## View available commands: `help`
## Exit the program: `exit`


