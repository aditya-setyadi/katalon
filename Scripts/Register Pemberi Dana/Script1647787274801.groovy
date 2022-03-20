import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.format.DateTimeFormatter as DateTimeFormatter

LocalDateTime now = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

String dateIdentifier = formatter.format(now)

SimpleDateFormat smt = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSS')

dateId = smt.parse(dateIdentifier)

epochDate = dateId.getTime().toString()

def generator = { String alphabet, int n ->
    new Random().with({ 
            (1..n).collect({ 
                    alphabet[nextInt(alphabet.length())]
                }).join()
        })
}

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev.p2p.alamisharia.co.id/')

WebUI.waitForElementVisible(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/a_Daftar disini'), 5)

WebUI.verifyElementClickable(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/a_Daftar disini'))

WebUI.click(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/a_Daftar disini'))

WebUI.waitForElementVisible(findTestObject('ALAMI/Page_ALAMI_Daftar-ALAMI_Peer-to-Peer_Lending/div_Pemberi Dana_button'), 
    0)

WebUI.click(findTestObject('ALAMI/Page_ALAMI_Daftar-ALAMI_Peer-to-Peer_Lending/div_Pemberi Dana_button'))

WebUI.setText(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/input_Nama Lengkap_name'), 'Ken ' + "${generator((('A'..'Z')+('a'..'z')).join(), 6)}")

WebUI.setText(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/input_Email_email'), ('ken_' + "$epochDate") + '@maildrop.cc')

WebUI.setText(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/input_No. Handphone_phone'), '08' + "$epochDate")

WebUI.setEncryptedText(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/input_Password_password'), GlobalVariable.defaultPassword)

WebUI.click(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/label_Individual'))

WebUI.click(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/button_Lanjutkan_Submit_PersonalData'))

WebUI.click(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/div_Bismillahirrahmanirrahim_TnC'))

WebUI.scrollToElement(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/p_Plaza 89, Kav. X7Jln. H.R. Rasuna Said_TnC'), 
    0)

WebUI.click(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/input_CheckBox_Setuju_TnC'))

WebUI.click(findTestObject('ALAMI/Page_Daftar_DataDiri_Pemberi_Dana/button_Lanjutkan_After_TnC'))

WebUI.verifyElementText(findTestObject('ALAMI/Page_Selesai_Mendaftar_Pemberi_Dana/h3_TerimaKasih'), 'Terima Kasih!')

WebUI.verifyElementClickable(findTestObject('ALAMI/Page_Selesai_Mendaftar_Pemberi_Dana/a_Kirim Ulang Aktivasi Email'))

WebUI.navigateToUrl('https://maildrop.cc')

WebUI.waitForElementVisible(findTestObject('Maildrop/Page_Maildrop/input'), 0)

WebUI.setText(findTestObject('Maildrop/Page_Maildrop/input'), 'ken_' + "$epochDate")

WebUI.click(findTestObject('Maildrop/Page_Maildrop/button_View Inbox'))

WebUI.waitForElementVisible(findTestObject('Maildrop/Page_inbox_ Maildrop/button_Reload'), 3)

loopStart = 1
maxLoop = 18

def waitingElementCustom(String locator) {
	try {
		WebUI.verifyElementPresent(findTestObject(locator), 10)
		return true
	} catch(StepFailedException ex) {
		return false
	}
}

while(!waitingElementCustom('Maildrop/Page_inbox_ Maildrop/div_Mina  ALAMI no-replyalamisharia.co.id')) {
	loopStart++
	if(loopStart <= maxLoop) {
		WebUI.click(findTestObject('Maildrop/Page_inbox_ Maildrop/button_Reload'))
	} else {
		break
	}
}

WebUI.click(findTestObject('Maildrop/Page_inbox_ Maildrop/div_Mina  ALAMI no-replyalamisharia.co.id'))

WebUI.switchToFrame(findTestObject('Maildrop/Page_inbox_ Maildrop/iframe_messageData-iframe'), 5)

WebUI.scrollToElement(findTestObject('Maildrop/Page_inbox_ Maildrop/p_Klik Untuk Aktivasi Email  Log-in'), 5)

WebUI.click(findTestObject('Maildrop/Page_inbox_ Maildrop/p_Klik Untuk Aktivasi Email  Log-in'))

WebUI.navigateToUrl('https://dev.p2p.alamisharia.co.id/')

WebUI.setText(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/input_Assalamualaikum_username'), ('ken_' + "$epochDate") + '@maildrop.cc')

WebUI.setEncryptedText(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/input_Assalamualaikum_password'), GlobalVariable.defaultPassword)

WebUI.click(findTestObject('ALAMI/Page_Login_ALAMI_Peer-to-Peer_Lending_Syariah/a_Masuk Ke Akun Saya'))

WebUI.verifyElementVisible(findTestObject('ALAMI/Page_Pemberi_Dana_Dashboard/h4_Lengkapi Profilmu Untuk Aktivasi Akun dan RDF (Rekening Dana Funder)'))
