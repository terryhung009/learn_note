new fullpage('#fullpage', {
    //options here
    autoScrolling: true,
    scrollHorizontally: true,
    onLeave: function (origin, destination, direction) {
        var loading2 = new TimelineMax();
        // gsap.fromTo(".box", { opacity: 0 }, { opacity: 0.5, duration: 1 });
        loading2.fromTo(".upper", 0.6, {
            autoAlpha: 0,

        }, {
            autoAlpha: 1,

        }, "+=0.6")

            .fromTo(".lower", 0.6, {
                autoAlpha: 0,

            }, {
                autoAlpha: 1,

            }, "-=0.6")
            ;
    },
});

document.addEventListener("DOMContentLoaded", function () {
    var loading = new TimelineMax();
    // gsap.fromTo(".box", { opacity: 0 }, { opacity: 0.5, duration: 1 });
    loading.fromTo(".upper h2", 0.6, {
        autoAlpha: 0,
        y: 20
    }, {
        autoAlpha: 1,
        y: 0
    })
        .fromTo(".upper p", 0.6, {
            autoAlpha: 0,

        }, {
            autoAlpha: 1,

        })
        .fromTo(".btn1", 0.6, {
            autoAlpha: 0,
            x: -20

        }, {
            autoAlpha: 1,
            x: 0
        }, "-=0.6")
        .fromTo(".btn2", 0.6, {
            autoAlpha: 0,
            x: 20

        }, {
            autoAlpha: 1,
            x: 0
        }, "-=0.6")
        .fromTo(".arrow", 0.6, {
            autoAlpha: 0,
            y: -20

        }, {
            autoAlpha: 1,
            y: 0
        })

        ;
});