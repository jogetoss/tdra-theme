$(".accessibility-widgets .widget-item").click(function () {
    accessiibility($(this));
});
$(".accessibility-box").click(function (e) {
    e.stopPropagation();
});

$(window).on("mousemove scroll click", function (e) {
    if ($(".reading-guide").length) {
        var RGWidth = $(".reading-guide").width();
        var xPos = $(".reading-guide").offset().left;
        var x = e.pageX;
        var y = e.pageY;
        var newposX = x;
        var newposY = y - 20;
        var maxXPos = RGWidth / 2;
        var leftPos = 0;
        var arrowPos;
        if (x <= maxXPos) {
            leftPos = maxXPos;
            arrowPos = newposX;
        } else if (x >= window.innerWidth - maxXPos) {
            leftPos = window.innerWidth - maxXPos;
            arrowPos = RGWidth - (window.innerWidth - newposX);
        } else {
            leftPos = newposX;
            arrowPos = "50%";
        }
        $(".reading-guide").css({
            top: newposY,
            left: leftPos
        });
        $(".reading-guide__arrow").css("left", arrowPos);
        $("body").css("overflow-x", "hidden");
    }
});
$(window).on("mousemove scroll click", function (e) {
    if ($(".reading-mask").length) {
        var timer;
        var mouseY = 0;
        var xp = 0
                , yp = 0;
        var twoLines = $(".reading-mask");
        var bottomMask = $(".reading-mask-two")
        function mouseStopped() {
            twoLines.removeClass('moving');
            bottomMask.removeClass('moving')
        }
        $(document).mousemove(function (e) {
            twoLines.addClass('moving');
            bottomMask.addClass('moving');
            mouseY = e.pageY - 25;
        });
        var loop = setInterval(function () {
            yp += ((mouseY - yp));
            twoLines.css({
                height: yp + 'px'
            });
            bottomMask.css({
                top: yp + 'px'
            });
        });
    }
});
function accessiibility(element) {
    var steps = $(element).find(".step");
    if (steps.first().attr("data-step") == undefined) {
        steps.first().attr("data-step", "current");
    } else if (steps.last().attr("data-step") == "current") {
        steps.removeAttr("data-step");
    } else {
        $(element).find(".step[data-step=current]").attr("data-step", "done").next().attr("data-step", "current");
    }
    if ($(element).attr("data-stepper") == "font-size") {
        var defaultFontSize = $(element).find("[data-font-size-default]").attr("data-font-size-default");
        if (!$(element).find(".step[data-step=current]").length) {
            $('body, html').css("font-size", defaultFontSize + "rem");
            Cookies.remove("FontSize");
        } else {
            var fontSize = $(element).find(".step[data-step=current]").attr("data-font-size");
            $('body, html').css("font-size", fontSize + "rem");
            Cookies.set("FontSize", fontSize);
        }
    }
    if ($(element).attr("data-stepper") == "font-family") {
        if (!$(element).find(".step[data-step=current]").length) {
            var defaultFont = $(element).find("[data-font-default]").attr("data-font-default-text");
            $("body").removeAttr("data-font");
            $(element).find("figcaption").html(defaultFont);
            Cookies.remove("FontFamily");
        } else {
            var fontTitle = $(element).find(".step[data-step=current]").attr("data-font-text");
            var fontName = $(element).find(".step[data-step=current]").attr("data-font");
            $(element).find("figcaption").html(fontTitle);
            $("body").attr("data-font", fontName);
            Cookies.set("FontFamily", fontName);
        }
    }
    if ($(element).attr("data-stepper") == "contrast") {
        var defaultContrast = $(element).find("[data-contrast-default]").attr("data-contrast-default-text");
        if (!$(element).find(".step[data-step=current]").length) {
            $(element).find("figcaption").html(defaultContrast);
            $("html").removeClass();
            Cookies.remove("Contrast");
        } else {
            var contrastTitle = $(element).find(".step[data-step=current]").attr("data-contrast-text");
            var contrastName = $(element).find(".step[data-step=current]").attr("data-contrast");
            $(element).find("figcaption").html(contrastTitle);
            $("html").removeClass().addClass(contrastName);
            Cookies.set("Contrast", contrastName);
        }
    }
    if ($(element).attr("data-stepper") == "color") {
        var defaultColor = $(element).find("[data-theme-default]").attr("data-theme-default-text");
        if (!$(element).find(".step[data-step=current]").length) {
            $(element).find("figcaption").html(defaultColor);
            $("html").removeAttr("data-theme-color");
            $("#colorTheme").attr("href", "/Assets/css/themes/default.css");
            Cookies.remove("ColorTheme");
        } else {
            var colorTitle = $(element).find(".step[data-step=current]").attr("data-theme-text");
            var colorName = $(element).find(".step[data-step=current]").attr("data-theme");
            $(element).find("figcaption").html(colorTitle);
            $("html").attr("data-theme-color", colorName);
            $("#colorTheme").attr("href", "/Assets/css/themes/" + colorName + ".css");
            Cookies.set("ColorTheme", colorName);
        }
    }
    if ($(element).attr("data-stepper") == "text-align") {
        var defaultTextAlign = $(element).find("[data-text-align-default]").attr("data-text-align-default");
        var defaultTextAlignText = $(element).find("[data-text-align-default]").attr("data-text-align-default-text");
        if (!$(element).find(".step[data-step=current]").length) {
            $(element).find("figcaption").html(defaultTextAlignText);
            $("html").removeAttr("data-text-align");
            $(element).find("figure i").attr("class", "zmdi zmdi-format-align-left");
            Cookies.remove("TextAlign");
        } else {
            var textAlignNameText = $(element).find(".step[data-step=current]").attr("data-text-align-text");
            var textAlignName = $(element).find(".step[data-step=current]").attr("data-text-align");
            $(element).find("figcaption").html(textAlignNameText);
            $("html").attr("data-text-align", textAlignName);
            $(element).find("figure i").attr("class", "zmdi zmdi-format-" + textAlignName);
            Cookies.set("TextAlign", textAlignName);
        }
    }
    if ($(element).attr("data-stepper") == "cursor") {
        var defaultCursor = $(element).find("[data-default]").attr("data-default");
        var defaultCursorText = $(element).find("[data-default]").attr("data-cursor-default-text");
        if (!$(element).find(".step[data-step=current]").length) {
            $(element).find("figcaption").html(defaultCursorText);
            $("html").removeAttr("data-cursor");
            $(element).find("figure i").attr("class", "fas fa-mouse-pointer");
            $("body").find(".reading-guide").remove();
            Cookies.remove("Cursor");
        } else {
            var cursorNameText = $(element).find(".step[data-step=current]").attr("data-cursor-text");
            var cursorName = $(element).find(".step[data-step=current]").attr("data-cursor");
            $(element).find("figcaption").html(cursorNameText);
            $("html").attr("data-cursor", cursorName);
            $(element).find("figure i").attr("class", cursorName);
            if (cursorName == "zmdi zmdi-format-valign-top") {
                $('body').append("<div class='reading-guide'><div class='reading-guide__arrow'></div></div>");
            }
            if (cursorName == "zmdi zmdi-center-focus-strong") {
                $('body').append("<div class='reading-mask'><div class='reading-mask-line'></div></div> <div class='reading-mask-two'><div class='readingmask-line-two'></div></div>");
            } else {
                $("body").find('.reading-mask').remove();
                $("body").find('.reading-mask-two').remove();
            }
            Cookies.set("Cursor", cursorName);
        }
    }
}
function resetAccessibility() {
    var defaultFontSize = $("html").find("[data-font-size-default]").attr("data-font-size-default");
    $('body, html').css("font-size", defaultFontSize + "rem");
    Cookies.remove("FontSize");
    var defaultFont = $("html").find("[data-font-default]").attr("data-font-default-text");
    $("body").removeAttr("data-font");
    $("[data-stepper=font-family]").find("figcaption").html(defaultFont);
    Cookies.remove("FontFamily");
    var defaultContrast = $("html").find("[data-contrast-default]").attr("data-contrast-default-text");
    $("[data-stepper='contrast']").find("figcaption").html(defaultContrast);
    $("html").removeClass();
    Cookies.remove("Contrast");
    var defaultColor = $("html").find("[data-theme-default]").attr("data-theme-default-text");
    $("[data-stepper='color']").find("figcaption").html(defaultColor);
    $("html").removeAttr("data-theme-color");
    $("#colorTheme").attr("href", "/Assets/css/themes/default.css");
    Cookies.remove("ColorTheme");
    var defaultTextAlignText = $("html").find("[data-text-align-default]").attr("data-text-align-default-text");
    $("[data-stepper='text-align']").find("figcaption").html(defaultTextAlignText);
    $("html").removeAttr("data-text-align");
    $("[data-stepper='text-align']").find("figure i").attr("class", "zmdi zmdi-format-align-left");
    Cookies.remove("TextAlign");
    var defaultCursorText = $("html").find("[data-default]").attr("data-cursor-default-text");
    $("[data-stepper='cursor']").find("figcaption").html(defaultCursorText);
    $("html").removeAttr("data-cursor");
    $("[data-stepper='cursor']").find("figure i").attr("class", "fas fa-mouse-pointer");
    $("body").find(".reading-guide").remove();
    $("body").find(".reading-mask").remove();
    $("body").find(".reading-mask-two").remove();
    Cookies.remove("Cursor");
    $(".step[data-step]").removeAttr('data-step');
}

var cookieFontSize = Cookies.get("FontSize");
var cookieFontFamily = Cookies.get("FontFamily");
var cookieContrast = Cookies.get("Contrast");
var cookieColorTheme = Cookies.get("ColorTheme");
var cookieTextAlign = Cookies.get("TextAlign");
var cookieCursor = Cookies.get("Cursor");
if (cookieFontSize) {
    $("[data-stepper='font-size']").find("[data-font-size='" + cookieFontSize + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    $('body, html').css("font-size", cookieFontSize + "rem");
}
if (cookieFontFamily) {
    $("[data-stepper='font-family']").find("[data-font='" + cookieFontFamily + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    $("body").attr("data-font", cookieFontFamily);
    $("[data-stepper='font-family']").find("figcaption").html(cookieFontFamily);
}
if (cookieContrast) {
    $("[data-stepper='contrast']").find("[data-contrast='" + cookieContrast + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    $("html").removeClass().addClass(cookieContrast);
    $("[data-stepper='contrast']").find("figcaption").html($("[data-stepper='contrast']").find("[data-contrast='" + cookieContrast + "']").attr("data-contrast-default-text"));
}
if (cookieColorTheme) {
    $("[data-stepper='color']").find("[data-theme='" + cookieColorTheme + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    $("html").attr("data-theme-color", cookieColorTheme);
    $("[data-stepper='color']").find("figcaption").html($("[data-stepper='color']").find("[data-theme='" + cookieColorTheme + "']").attr("data-theme-text"));
}
if (cookieTextAlign) {
    $("[data-stepper='text-align']").find("[data-text-align='" + cookieTextAlign + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    $("[data-stepper='text-align']").find("figcaption").html($("[data-stepper='text-align']").find("[data-text-align='" + cookieTextAlign + "']").attr("data-text-align-text"));
    $("html").attr("data-text-align", cookieTextAlign);
    $("[data-stepper='text-align']").find("figure i").attr("class", "zmdi zmdi-format-" + cookieTextAlign);
}
if (cookieCursor) {
    $("[data-stepper='cursor']").find("[data-cursor='" + cookieCursor + "']").attr("data-step", "current").prevAll().attr("data-step", "done");
    var cursorName = $("[data-stepper='cursor']").find("[data-cursor='" + cookieCursor + "']").attr("data-cursor-name");
    var cursorText = $("[data-stepper='cursor']").find("[data-cursor='" + cookieCursor + "']").attr("data-cursor-text");
    $("[data-stepper='cursor']").find("figcaption").html(cursorText);
    $("html").attr("data-cursor", cookieCursor);
    $("[data-stepper='cursor']").find("figure i").attr("class", cookieCursor);
    if (cursorName == "reading-guide") {
        $('body').append("<div class='reading-guide'><div class='reading-guide__arrow'></div></div>");
    }
    if (cursorName == "reading-mask") {
        $('body').append("<div class='reading-mask'><div class='reading-mask-line'></div></div> <div class='reading-mask-two'><div class='readingmask-line-two'></div></div>");
    }
}