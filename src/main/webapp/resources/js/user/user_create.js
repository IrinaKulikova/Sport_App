$(function () {
    $(function () {
            $(".btn-create-user").click(function (e) {
                var userCreateForm = $(".create-user-form");
                    $(function () {
                        userCreateForm.validate({
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
                    });
                    if (userCreateForm.valid()) {
                        var user = new User($('#fname').val(),
                            $('#lname').val(), $('#email').val(),
                            $('#phone').val(), $('#pass').val());
                        let service = new AJAXService();

                        function success() {
                            location.replace("/users");
                        };

                        function fail() {
                            console.log('fail');
                        };

                        service.post("/api/1.0/users", user, success, fail);
                        e.preventDefault();
                    }
                }
            );
    });

});