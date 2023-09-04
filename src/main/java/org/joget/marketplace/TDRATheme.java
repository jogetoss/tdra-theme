package org.joget.marketplace;

import java.util.Map;
import org.joget.apps.app.service.AppUtil;
import org.joget.apps.userview.lib.AjaxUniversalTheme;
import org.joget.plugin.base.PluginManager;


public class TDRATheme extends AjaxUniversalTheme{
    public static String MESSAGE_PATH = "message/TDRATheme";
    
    @Override
    public String getName() {
        return "TDRA Theme";
    }

    @Override
    public String getVersion() {
        return "8.0.0";
    } 

    @Override
    public String getLabel() {
        return getName();
    }
    
    @Override
    public String getDescription() {
        return "A Telecommunication And Digital Government Regulatory Authority Theme based on Material Design";
    }
    
    @Override
    public String getClassName() {
        return getClass().getName();
    }
    
    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClass().getName(), "/properties/dx8TDRATheme.json", null, true, MESSAGE_PATH);
    }
    
    @Override
   protected String getNavbar(Map<String, Object> data) {
        String html = "<div class=\"nav-no-collapse header-nav\"><ul class=\"nav pull-right\">\n";
        html += getHomeLink(data);
        if ((Boolean) data.get("is_logged_in")) {
            html += getInbox(data);
        }
        html += getShortcut(data);
        if ("true".equals(getPropertyString("darkMode"))) {
            html += getThemeSwitch(data);
        }
        html += getAccessibilityFeature(data);
        html += getUserMenu(data);
        html += "</ul></div>\n";
        return html;
    }
   
   @Override
    public String getJsCssLib(Map<String, Object> data) {
        if (isAjaxContent(data)) {
            return "";
        } else {
            String jsCssLink = super.getJsCssLib(data);
            jsCssLink += "<script src=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/js.cookie.min.js\" defer></script>\n";
            jsCssLink += "<script src=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/accessibilityFeature.js\" defer></script>\n";
            jsCssLink += "<link rel=\"stylesheet\" href=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/TDRATheme.css\"></link>\n";
            jsCssLink += "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">";
            jsCssLink += "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>";
            jsCssLink += "<link href=\"https://fonts.googleapis.com/css2?family=Noto+Kufi+Arabic:wght@100;200;300;400;500;600;700;800;900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\">";
            return jsCssLink;
        }
    }
    
    protected String getAccessibilityFeature(Map<String, Object> data) {
        PluginManager pluginManager = (PluginManager) AppUtil.getApplicationContext().getBean("pluginManager");
        
        return "<li class=\"accessibility-dropdown dropdown\">\n"
                + "    <a data-toggle=\"dropdown\" href=\"javascript:;\" class=\"btn dropdown-toggle\">\n"
                + "	 <i class=\"fas fa-universal-access\"></i>\n"
                + "    </a>\n"
                + "    <div class=\"dropdown-menu accessibility-box\" data-close=\"false\">\n"
                + "                            <div class=\"card\">\n"
                + "                                <div class=\"card-header px-4\">\n"
                + "                                    <h4 class=\"card-title text-white\">"+ pluginManager.getMessage("theme.tdratheme.accesibility.menu" , getClass().getName(), MESSAGE_PATH) + "</h4>\n"
                + "                                </div>\n"
                + "                                <div class=\"card-body\">\n"
                + "                                    <div class=\"accessibility-widgets\">\n"
                + "                                        <div class=\"widget-items d-flex justify-content-center align-items-center\">\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"font-size\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"zmdi zmdi-format-size\" width=\"48\" height=\"48\"></i>\n"
                + "                                                    <figcaption>\n"
                + "                                                        " + pluginManager.getMessage("theme.tdratheme.accesibility.menu.fontSize" , getClass().getName(), MESSAGE_PATH) + "\n"
                + "                                                    </figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-font-size-default=\"1\">\n"
                + "                                                    <div class=\"step\" data-font-size=\"1.1\"></div>\n"
                + "                                                    <div class=\"step\" data-font-size=\"1.2\"></div>\n"
                + "                                                    <div class=\"step\" data-font-size=\"1.3\"></div>\n"
                + "                                                    <div class=\"step\" data-font-size=\"1.4\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"font-family\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"fas fa-text-width\" width=\"48\" height=\"48\"></i>"
                + "                                                    <figcaption>Roboto</figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-font-default=\"Roboto\" data-font-default-text=\"Roboto\">\n"
                + "                                                    <div class=\"step\" data-font=\"SF-Pro\" data-font-text=\"SF-Pro\"></div>\n"
                + "                                                    <div class=\"step\" data-font=\"DA-Kufi\" data-font-text=\"DA-Kufi\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"widget-items d-flex justify-content-center align-items-center\">\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"color\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"zmdi zmdi-palette\" width=\"48\" height=\"48\"></i>\n"
                + "                                                    <figcaption>" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.color.theme" , getClass().getName(), MESSAGE_PATH) + "</figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-theme-default=\"color theme\" data-theme-default-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.color.theme" , getClass().getName(), MESSAGE_PATH) + "\">\n"
                + "                                                    <div class=\"step\" data-theme=\"gold\" data-theme-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.gold" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-theme=\"green\" data-theme-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.green" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-theme=\"red\" data-theme-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.red" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"contrast\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"fas fa-adjust\" width=\"48\" height=\"48\"></i>\n"
                + "                                                    <figcaption>" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.contrast" , getClass().getName(), MESSAGE_PATH) + "</figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-contrast-default=\"text align\" data-contrast-default-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.contrast" , getClass().getName(), MESSAGE_PATH) + "\">\n"
                + "                                                    <div class=\"step\" data-contrast=\"invert\" data-contrast-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.invert" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-contrast=\"desaturate\" data-contrast-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.desaturate" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-contrast=\"dark-contrast\" data-contrast-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.dark.contrast" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-contrast=\"hue-rotate\" data-contrast-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.hue.rotate" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"widget-items d-flex justify-content-center align-items-center\">\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"text-align\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"zmdi zmdi-format-align-left\" width=\"48\" height=\"48\"></i>\n"
                + "                                                    <figcaption>" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.text.align" , getClass().getName(), MESSAGE_PATH) + "</figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-text-align-default=\"text align\" data-text-align-default-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.text.align" , getClass().getName(), MESSAGE_PATH) + "\">\n"
                + "                                                    <div class=\"step\" data-text-align=\"align-left\" data-text-align-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.align.left" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-text-align=\"align-center\" data-text-align-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.align.center" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-text-align=\"align-right\" data-text-align-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.align.right" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"widget-item\" data-stepper=\"cursor\">\n"
                + "                                                <figure class=\"text-center\">\n"
                + "                                                    <i class=\"fas fa-mouse-pointer\" width=\"48\" height=\"48\"></i>\n"
                + "                                                    <figcaption>" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.cursor" , getClass().getName(), MESSAGE_PATH) + "</figcaption>\n"
                + "                                                </figure>\n"
                + "                                                <div class=\"steps d-flex align-items-center\" data-default=\"cursor\" data-cursor-default-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.cursor" , getClass().getName(), MESSAGE_PATH) + "\">\n"
                + "                                                    <div class=\"step\" data-cursor-name=\"big-cusor\" data-cursor=\"fas fa-mouse-pointer\" data-cursor-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.big.cursor" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-cursor-name=\"reading-mask\" data-cursor=\"zmdi zmdi-center-focus-strong\" data-cursor-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.reading.mask" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                    <div class=\"step\" data-cursor-name=\"reading-guide\" data-cursor=\"zmdi zmdi-format-valign-top\" data-cursor-text=\"" + pluginManager.getMessage("theme.tdratheme.accesibility.menu.reading.guide" , getClass().getName(), MESSAGE_PATH) + "\"></div>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"widget-items d-flex justify-content-end align-items-center pt-3\">\n"
                + "                                            <a class=\"text-primary btn-icon-right font-size-sm\" onclick=\"resetAccessibility()\" href=\"javascript:;\">\n"
                + "                                                " + pluginManager.getMessage("theme.tdratheme.accesibility.menu.reset" , getClass().getName(), MESSAGE_PATH) + "\n"
                + "                                            </a>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </div>"
                + "<li>";
    }
}
