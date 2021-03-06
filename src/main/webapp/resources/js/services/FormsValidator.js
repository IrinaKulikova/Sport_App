class FormsValidator{
    userCreateForm(form){
        form.validate({
            rules: {
                firstName: {
                    required: true,
                    maxlength: 16
                },
                lastName: {
                    required: true,
                    maxlength: 16
                },
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    minlength: 10,
                    maxlength: 18
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 12
                }
            },
            messages: {
                firstName: {
                    required: "First name cant be empty!",
                    maxlength: "Max length: 16 symbols!"
                },
                lastName: {
                    required: "Last name cant be empty!",
                    maxlength: "Max length: 16 symbols!"
                },
                email: {
                    required: "Email cant be empty!",
                    email: "Is not valid email address!"
                },
                phone: {
                    required: "Phone cant be empty!",
                    minlength: "Min length: 10 symbols!",
                    maxlength: "Max length: 18 symbols!"
                },
                password: {
                    required: "Password cant be empty!",
                    minlength: "Min length: 6 symbols!",
                    maxlength: "Max length: 12 symbols!"
                }
            }
        });
        return form.valid();
    }
    cardCreateForm(form){
        form.validate({
            rules: {
                description: {
                    required: true,
                    maxlength: 30
                },
                issueDate: {
                    required: true,
                    date: true
                },
                expirationDate: {
                    required: true,
                    date: true
                },
                pinCode: {
                    required: true,
                    minlength: 4,
                    maxlength: 4,
                    number: true
                }
            },
            messages: {
                description: {
                    required: "Description cant be empty!",
                    maxlength: "Max length: 30 symbols!"
                },
                issueDate: {
                    required: "Issue Date cant be empty!",
                    date: "Invalid date format!"
                },
                expirationDate: {
                    required: "Expiration Date cant be empty!",
                    date: "Invalid date format!"
                },
                pinCode: {
                    required: "Pin code cant be empty!",
                    minlength: "Pin code must be 4 numeric symbols!",
                    maxlength: "Pin code must be 4 numeric symbols!",
                    number: "Pin code must contain only numbers!"
                }
            }
        });
        return form.valid();
    }
    userEditForm(form){
        form.validate({
            rules: {
                firstName: {
                    required: true,
                    maxlength: 16
                },
                lastName: {
                    required: true,
                    maxlength: 16
                },
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    minlength: 10,
                    maxlength: 18
                },
                password: {
                    minlength: 6,
                    maxlength: 12
                }
            },
            messages: {
                firstName: {
                    required: "First name cant be empty!",
                    maxlength: "Max length: 16 symbols!"
                },
                lastName: {
                    required: "Last name cant be empty!",
                    maxlength: "Max length: 16 symbols!"
                },
                email: {
                    required: "Email cant be empty!",
                    email: "Is not valid email address!"
                },
                phone: {
                    required: "Phone cant be empty!",
                    minlength: "Min length: 10 symbols!",
                    maxlength: "Max length: 18 symbols!"
                },
                password: {
                    minlength: "Min length: 6 symbols!",
                    maxlength: "Max length: 12 symbols!"
                }
            }
        });
        return form.valid();
    }
    newsCreateForm(form){
        form.validate({
            rules: {
                date: {
                    required: true,
                    date: true
                },
                title: {
                    required: true,
                    maxlength: 150
                },
                description: {
                    required: true
                },
                imageURL: {
                    url: true
                }
            },
            messages: {
                date: {
                    required: "Date cant be empty!",
                    date: "Invalid date format!"
                },
                title: {
                    required: "Title cant be empty!",
                    maxlength: "Max length: 150 symbols!"
                },
                description: {
                    required: "Description cant be empty!"
                },
                imageURL: {
                    url: "Is not url"
                }
            }
        });
        return form.valid();
    }
    newsEditForm(form){
        form.validate({
            rules: {
                date: {
                    required: true,
                    date: true
                },
                title: {
                    required: true,
                    maxlength: 150
                },
                description: {
                    required: true
                },
                imageURL: {
                    url: true
                }
            },
            messages: {
                date: {
                    required: "Date cant be empty!",
                    date: "Invalid date format!"
                },
                title: {
                    required: "Title cant be empty!",
                    maxlength: "Max length: 150 symbols!"
                },
                description: {
                    required: "Description cant be empty!"
                },
                imageURL: {
                    url: "Is not url"
                }
            }
        });
        return form.valid();
    }
    filiationForm(form){
        form.validate({
            rules: {
                caption: {
                    required: true,
                    maxlength: 50
                },
                country: {
                    required: true,
                    maxlength: 50
                },
                city: {
                    required: true,
                    maxlength: 50
                },
                street: {
                    required: true,
                    maxlength: 150
                },
                building: {
                    maxlength: 20
                },
                indexCity: {
                    maxlength: 20,
                    number: true
                }
            },
            messages: {
                caption: {
                    required: "Caption cant be empty!",
                    maxlength: "Max length: 50 symbols!"
                },
                country: {
                    required: "Country cant be empty!",
                    maxlength: "Max length: 50 symbols!"
                },
                city: {
                    required: "City cant be empty!",
                    maxlength: "Max length: 50 symbols!"
                },
                street: {
                    required: "Street cant be empty!",
                    maxlength: "Max length: 150 symbols!"
                },
                building: {
                    maxlength: "Max length: 20 symbols!"
                },
                indexCity: {
                    maxlength: "Max length: 20 symbols!",
                    number: "Index must be a number!"
                }
            }
        });
        return form.valid();
    }
    eventForm(form){
        form.validate({
            rules: {
                name: {
                    required: true,
                    maxlength: 20
                },
                description: {
                    required: true,
                    maxlength: 100
                }
            },
            messages: {
                name: {
                    required: "Name cant be empty!",
                    maxlength: "Max length: 20 symbols!"
                },
                description: {
                    required: "Description cant be empty!",
                    maxlength: "Max length: 100 symbols!"
                }
            }
        });
        return form.valid();
    }
    adminCreateForm(form){
        form.validate({
            rules: {
                login: {
                    required: true,
                    minlength: 5,
                    maxlength: 12
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                login: {
                    required: "Login cant be empty!",
                    maxlength: "Login length 5-12 symbols!"
                },
                email: {
                    required: "Email cant be empty!",
                    email: "Not valid email address!"
                }
            }
        });
        return form.valid();
    }
    adminEditForm(form){
        form.validate({
            rules: {
                login: {
                    required: true,
                    minlength: 5,
                    maxlength: 12
                },
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5,
                    maxlength: 12
                },
                confirm: {
                    required: true,
                    minlength: 5,
                    maxlength: 12,
                    equalTo: "#password1"
                }

            },
            messages: {
                login: {
                    required: "Login cant be empty!",
                    maxlength: "Login length 5-12 symbols!"
                },
                email: {
                    required: "Email cant be empty!",
                    email: "Not valid email address!"
                },
                passw1: {
                    required: "Password cant be empty!",
                    maxlength: "Password length 5-12 symbols!",
                    minlength: "Password length 5-12 symbols!"
                }
            }
        });
        return form.valid();
    }

}

