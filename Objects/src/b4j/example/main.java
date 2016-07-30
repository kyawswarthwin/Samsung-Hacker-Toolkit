package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            BA.Log("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 390, 590);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _vv1 = null;
public static anywheresoftware.b4j.objects.Form _v5 = null;
public static anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper _mnufileclose = null;
public static anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper _mnutoolsrebootdownload = null;
public static anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper _mnuhelpabout = null;
public static anywheresoftware.b4j.objects.ComboBoxWrapper _cmbport = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnscan = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnopen = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _txtlog = null;
public static anywheresoftware.b4j.serial.Serial _v6 = null;
public static anywheresoftware.b4a.randomaccessfile.AsyncStreams _v7 = null;
public static anywheresoftware.b4a.agraham.jmsgboxes.Msgboxes _v0 = null;
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 22;BA.debugLine="MainForm = Form1";
_v5 = _form1;
 //BA.debugLineNum = 23;BA.debugLine="MainForm.RootPane.LoadLayout(\"Main\")";
_v5.getRootPane().LoadLayout(ba,"Main");
 //BA.debugLineNum = 24;BA.debugLine="MainForm.Title = \"Samsung Hacker Toolkit\"";
_v5.setTitle("Samsung Hacker Toolkit");
 //BA.debugLineNum = 25;BA.debugLine="MainForm.Resizable = False";
_v5.setResizable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 26;BA.debugLine="MainForm.Show";
_v5.Show();
 //BA.debugLineNum = 27;BA.debugLine="sp.Initialize(\"\")";
_v6.Initialize("");
 //BA.debugLineNum = 28;BA.debugLine="btnScan_Action";
_btnscan_action();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _astream_error() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub AStream_Error";
 //BA.debugLineNum = 81;BA.debugLine="astream.Close";
_v7.Close();
 //BA.debugLineNum = 82;BA.debugLine="AStream_Terminated";
_astream_terminated();
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _astream_newdata(byte[] _buffer) throws Exception{
String _s = "";
 //BA.debugLineNum = 71;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 72;BA.debugLine="Dim s As String = BytesToString(Buffer, 0, Buffer";
_s = anywheresoftware.b4a.keywords.Common.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8");
 //BA.debugLineNum = 73;BA.debugLine="Select s.SubString2(0, s.IndexOf(\":\"))";
switch (BA.switchObjectToInt(_s.substring((int) (0),_s.indexOf(":")),"AT+DEVCONINFO+DEVCONINFO")) {
case 0:
 //BA.debugLineNum = 75;BA.debugLine="s = s.SubString(s.IndexOf(\":\") + 1).Trim";
_s = _s.substring((int) (_s.indexOf(":")+1)).trim();
 //BA.debugLineNum = 76;BA.debugLine="txtLog.Text = s.SubString2(0, s.IndexOf(\"#OK#\")";
_txtlog.setText(_s.substring((int) (0),_s.indexOf("#OK#")).replace(";",anywheresoftware.b4a.keywords.Common.CRLF));
 break;
}
;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _astream_terminated() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub AStream_Terminated";
 //BA.debugLineNum = 86;BA.debugLine="mnuToolsRebootDownload.Enabled = False";
_mnutoolsrebootdownload.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 87;BA.debugLine="cmbPort.Enabled = True";
_cmbport.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 88;BA.debugLine="btnScan.Enabled = True";
_btnscan.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 89;BA.debugLine="btnOpen.Text = \"Open\"";
_btnopen.setText("Open");
 //BA.debugLineNum = 90;BA.debugLine="txtLog.Text = \"\"";
_txtlog.setText("");
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _btnopen_action() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub btnOpen_Action";
 //BA.debugLineNum = 58;BA.debugLine="If btnOpen.Text = \"Close\" Then";
if ((_btnopen.getText()).equals("Close")) { 
 //BA.debugLineNum = 59;BA.debugLine="sp.Close";
_v6.Close();
 }else {
 //BA.debugLineNum = 61;BA.debugLine="sp.Open(cmbPort.Value)";
_v6.Open(BA.ObjectToString(_cmbport.getValue()));
 //BA.debugLineNum = 62;BA.debugLine="astream.Initialize(sp.GetInputStream, sp.GetOutp";
_v7.Initialize(ba,_v6.GetInputStream(),_v6.GetOutputStream(),"AStream");
 //BA.debugLineNum = 63;BA.debugLine="mnuToolsRebootDownload.Enabled = True";
_mnutoolsrebootdownload.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 64;BA.debugLine="cmbPort.Enabled = False";
_cmbport.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 65;BA.debugLine="btnScan.Enabled = False";
_btnscan.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 66;BA.debugLine="btnOpen.Text = \"Close\"";
_btnopen.setText("Close");
 //BA.debugLineNum = 67;BA.debugLine="astream.Write(\"AT+DEVCONINFO\".GetBytes(\"UTF8\"))";
_v7.Write("AT+DEVCONINFO".getBytes("UTF8"));
 };
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public static String  _btnscan_action() throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub btnScan_Action";
 //BA.debugLineNum = 52;BA.debugLine="cmbPort.Items.Clear";
_cmbport.getItems().Clear();
 //BA.debugLineNum = 53;BA.debugLine="cmbPort.Items.AddAll(sp.ListPorts)";
_cmbport.getItems().AddAll(_v6.ListPorts());
 //BA.debugLineNum = 54;BA.debugLine="cmbPort.SelectedIndex = 0";
_cmbport.setSelectedIndex((int) (0));
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _cmbport_selectedindexchanged(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub cmbPort_SelectedIndexChanged(Index As Int, Val";
 //BA.debugLineNum = 48;BA.debugLine="btnOpen.Enabled = Index > -1";
_btnopen.setEnabled(_index>-1);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_closed() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub MainForm_Closed";
 //BA.debugLineNum = 32;BA.debugLine="sp.Close";
_v6.Close();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _mnufileclose_action() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub mnuFileClose_Action";
 //BA.debugLineNum = 36;BA.debugLine="MainForm.Close";
_v5.Close();
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _mnuhelpabout_action() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub mnuHelpAbout_Action";
 //BA.debugLineNum = 44;BA.debugLine="Msgbox.Show(\"Samsung Hacker Toolkit\" & CRLF & CRL";
_v0.Show("Samsung Hacker Toolkit"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Version: 0.1 Beta"+anywheresoftware.b4a.keywords.Common.CRLF+"Developed By: Kyaw Swar Thwin","About");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _mnutoolsrebootdownload_action() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub mnuToolsRebootDownload_Action";
 //BA.debugLineNum = 40;BA.debugLine="astream.Write(\"AT+FUS?\".GetBytes(\"UTF8\"))";
_v7.Write("AT+FUS?".getBytes("UTF8"));
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private fx As JFX";
_vv1 = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 8;BA.debugLine="Private MainForm As Form";
_v5 = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 9;BA.debugLine="Private mnuFileClose As MenuItem";
_mnufileclose = new anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private mnuToolsRebootDownload As MenuItem";
_mnutoolsrebootdownload = new anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private mnuHelpAbout As MenuItem";
_mnuhelpabout = new anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private cmbPort As ComboBox";
_cmbport = new anywheresoftware.b4j.objects.ComboBoxWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private btnScan As Button";
_btnscan = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private btnOpen As Button";
_btnopen = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private txtLog As TextArea";
_txtlog = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private sp As Serial";
_v6 = new anywheresoftware.b4j.serial.Serial();
 //BA.debugLineNum = 17;BA.debugLine="Private astream As AsyncStreams";
_v7 = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 18;BA.debugLine="Private Msgbox As Msgboxes";
_v0 = new anywheresoftware.b4a.agraham.jmsgboxes.Msgboxes();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
