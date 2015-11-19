package cse.minorproject.guidepath;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class NearestStop extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_stop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.nearest_stn);
        mGoogleApiClient = new GoogleApiClient.Builder(this).addOnConnectionFailedListener(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override
    public void onConnected(Bundle bundle) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location != null) {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            double lats[] = new double[]{
                    28.725861,
                    28.716587,
                    28.707158,
                    28.702966,
                    28.69772,
                    28.694749,
                    28.687923,
                    28.676424,
                    28.6675,
                    28.676973,
                    28.648167,
                    28.642222,
                    28.631578,
                    28.623556,
                    28.615214,
                    28.610752,
                    28.597608,
                    28.5862505,
                    28.57406,
                    28.566808,
                    28.559948,
                    28.543982,
                    28.528545,
                    28.520528,
                    28.512942,
                    28.506667,
                    28.49926,
                    28.492973,
                    28.480833,
                    28.481996,
                    28.481389,
                    28.479595,
                    28.471507,
                    28.458827,
                    28.720833,
                    28.715,
                    28.707778,
                    28.703056,
                    28.698056,
                    28.695833,
                    28.688889,
                    28.6825,
                    28.673333,
                    28.67,
                    28.666667,
                    28.666389,
                    28.667222,
                    28.6675,
                    28.668333,
                    28.669722,
                    28.671944,
                    28.673611,
                    28.675278,
                    28.301667,
                    28.675556,
                    28.552349,
                    28.567889,
                    28.57297,
                    28.581389,
                    28.586389,
                    28.592222,
                    28.597778,
                    28.602222,
                    28.615,
                    28.619167,
                    28.620278,
                    28.621944,
                    28.624444,
                    28.629444,
                    28.632778,
                    28.636667,
                    28.640556,
                    28.643611,
                    28.648889,
                    28.653056,
                    28.658056,
                    28.655,
                    28.651944,
                    28.645049,
                    28.642,
                    28.643,
                    28.644,
                    28.639,
                    28.632,
                    28.63,
                    28.625,
                    28.623,
                    28.62,
                    28.62,
                    28.629,
                    28.6377,
                    28.641,
                    28.648,
                    28.647,
                    28.6454528,
                    28.6498175,
                    28.62,
                    28.618,
                    28.604,
                    28.594,
                    28.588538,
                    28.585824,
                    28.578631,
                    28.570408,
                    28.564208,
                    28.56694,
                    28.574,
                    28.627754,
                    28.625944,
                    28.6263361,
                    28.615214,
                    28.602402,
                    28.590443,
                    28.583698,
                    28.5705995,
                    28.5640005,
                    28.5553763,
                    28.551328,
                    28.549524,
                    28.545787,
                    28.5429197,
                    28.5381549,
                    28.529397,
                    28.5195888,
                    28.5032466,
                    28.4931605,
                    28.642222,
                    28.628826,
                    28.591847,
                    28.548805,
                    28.557024,
                    28.552349,
                    28.682442,
                    28.6822,
                    28.682106,
                    28.682356,
                    28.681792,
                    28.680994,
                    28.679703,
                    28.678589,
                    28.677294,
                    28.676361,
                    28.674944,
                    28.672936,
                    28.671603,
                    28.673333,
                    28.6585087,
                    28.655
            };
            double longs[] = new double[]{
                    77.16273,
                    77.170331,
                    77.180066,
                    77.19365,
                    77.206779,
                    77.214603,
                    77.22173,
                    77.224939,
                    77.228056,
                    77.224975,
                    77.22594,
                    77.221667,
                    77.220105,
                    77.214532,
                    77.211978,
                    77.212558,
                    77.211325,
                    77.2101331,
                    77.20949,
                    77.208104,
                    77.206946,
                    77.206426,
                    77.203303,
                    77.201505,
                    77.186349,
                    77.175,
                    77.161368,
                    77.149056,
                    77.125833,
                    77.102229,
                    77.093056,
                    77.080334,
                    77.072006,
                    77.072375,
                    77.106944,
                    77.115278,
                    77.125833,
                    77.1325,
                    77.140833,
                    77.1525,
                    77.161667,
                    77.164722,
                    77.170278,
                    77.181667,
                    77.198889,
                    77.206944,
                    77.216389,
                    77.228056,
                    77.25,
                    77.266667,
                    77.278056,
                    77.29,
                    77.301667,
                    77.3125,
                    77.320278,
                    77.058065,
                    77.066409,
                    77.066221,
                    77.056944,
                    77.049444,
                    77.040556,
                    77.0325,
                    77.025833,
                    77.022778,
                    77.033333,
                    77.045,
                    77.056389,
                    77.065,
                    77.078333,
                    77.086111,
                    77.096389,
                    77.105,
                    77.112778,
                    77.1225,
                    77.131389,
                    77.1425,
                    77.151389,
                    77.1575,
                    77.169251,
                    77.178263,
                    77.188541,
                    77.199812,
                    77.208502,
                    77.219639,
                    77.223582,
                    77.234724,
                    77.242523,
                    77.249991,
                    77.260113,
                    77.275273,
                    77.288947,
                    77.295143,
                    77.304708,
                    77.316091,
                    77.3221903,
                    77.3398,
                    77.260113,
                    77.279248,
                    77.289328,
                    77.294494,
                    77.301484,
                    77.311225,
                    77.317377,
                    77.326235,
                    77.334781,
                    77.345467,
                    77.3561,
                    77.241778,
                    77.234082,
                    77.219282,
                    77.211978,
                    77.229091,
                    77.23305,
                    77.238436,
                    77.236359,
                    77.234096,
                    77.2419936,
                    77.251759,
                    77.259148,
                    77.263938,
                    77.27514,
                    77.283202,
                    77.288005,
                    77.294396,
                    77.299986,
                    77.3029151,
                    77.221667,
                    77.211437,
                    77.161749,
                    77.120747,
                    77.086816,
                    77.058065,
                    77.030219,
                    77.043844,
                    77.056083,
                    77.064675,
                    77.073953,
                    77.080775,
                    77.0925,
                    77.102106,
                    77.112272,
                    77.119561,
                    77.130347,
                    77.145972,
                    77.155011,
                    77.170278,
                    77.143258,
                    77.151389


            };
            String stations[] = new String[]{
                    "Jahangirpuri"
                    , "Adarsh Nagar"
                    , "Azadpur"
                    , "Model Town"
                    , "GTB Nagar"
                    , "Vishwavidyalaya"
                    , "Vidhan Sabha"
                    , "Civil Lines"
                    , "Kashmere Gate"
                    , "Chandni Chowk"
                    , "Chawri Bazar"
                    , "New Delhi"
                    , "Rajiv Chowk"
                    , "Patel Chowk"
                    , "Central Secretariat"
                    , "Udyog Bhawan"
                    , "Race Course"
                    , "Jor Bagh"
                    , "INA"
                    , "AIIMS"
                    , "Green Park"
                    , "Hauz Khas"
                    , "Malviya Nagar"
                    , "Saket"
                    , "Qutub Minar"
                    , "Chhatarpur"
                    , "Sultanpur"
                    , "Ghitorni"
                    , "Arjangarh"
                    , "Guru Dronacharya"
                    , "Sikandarpur"
                    , "MG Road"
                    , "IFFCO Chowk"
                    , "Huda City Centre"
                    , "Rithala"
                    , "Rohini West"
                    , "Rohini East"
                    , "Pitampura"
                    , "Kohat Enclave"
                    , "NSP"
                    , "Keshav Puram"
                    , "Kanhaiya Nagar"
                    , "Inderlok"
                    , "Shastri Nagar"
                    , "Pratap Nagar"
                    , "Pulbangash"
                    , "Tis Hazari"
                    , "Kashmere Gate"
                    , "Shastri Park"
                    , "Seelampur"
                    , "Welcome"
                    , "Shahdara"
                    , "Mansarovar Park"
                    , "Jhilmil"
                    , "Dilshad Garden"
                    , "Dwarka Sector 21"
                    , "Dwarka Sector 8"
                    , "Dwarka Sector 9"
                    , "Dwarka Sector 10"
                    , "Dwarka Sector 11"
                    , "Dwarka Sector 12"
                    , "Dwarka Sector 13"
                    , "Dwarka Sector 14"
                    , "Dwarka"
                    , "Dwarka Mor"
                    , "Newada"
                    , "Uttam Nagar West"
                    , "Uttam Nagar East"
                    , "Janakpuri West"
                    , "Janakpuri East"
                    , "Tilak Nagar"
                    , "Subhash Nagar"
                    , "Tagore Garden"
                    , "Rajouri Garden"
                    , "Ramesh Nagar"
                    , "Moti Nagar"
                    , "Kirti Nagar"
                    , "Shadipur"
                    , "Patel Nagar"
                    , "Rajendra Place"
                    , "Karol Bagh"
                    , "Jhandewalan"
                    , "RK Ashram Marg"
                    , "Rajiv Chowk"
                    , "Barakhamba Road"
                    , "Mandi House"
                    , "Pragati Maidan"
                    , "Indraprastha"
                    , "Yamuna Bank(to vaishali)"
                    , "Laxmi Nagar"
                    , "Nirman Vihar"
                    , "Preet Vihar"
                    , "Karkarduma"
                    , "Anand Vihar ISBT"
                    , "Kaushambi"
                    , "KB Vaishali"
                    , "Yamuna Bank(to noida city centre)"
                    , "Akshardham"
                    , "Mayur Vihar-I"
                    , "Mayur Vihar-I Ext."
                    , "New Ashok Nagar"
                    , "Noida Sector 15"
                    , "Noida Sector 16"
                    , "Noida Sector 18"
                    , "Botanical Garden"
                    , "Golf Course"
                    , "Noida City Centre"
                    , "ITO"
                    , "Mandi House"
                    , "Janpath"
                    , "Central Secretariat"
                    , "Khan Market"
                    , "JLN Stadium"
                    , "Jangpura"
                    , "Lajpat Nagar"
                    , "Moolchand"
                    , "Kailash Colony"
                    , "Nehru Place"
                    , "Kalkaji Mandir"
                    , "Govindpuri"
                    , "Harkesh Nagar Okhla"
                    , "Jasola"
                    , "Sarita Vihar"
                    , "Mohan Estate"
                    , "Tughlakabad"
                    , "Badarpur Border"
                    , "New Delhi"
                    , "Shivaji Stadium"
                    , "Dhaula Kuan"
                    , "Delhi Aerocity"
                    , "IGI"
                    , "Dwarka Sector 21"
                    , "Mundka"
                    , "Rajdhani Park"
                    , "Nangloi Railway Station"
                    , "Nangloi"
                    , "Surajmal Stadium"
                    , "Udyog Nagar"
                    , "Peera Garhi"
                    , "Paschim Vihar West"
                    , "Paschim Vihar East"
                    , "Madipur"
                    , "Shivaji Park"
                    , "Punjabi Bagh East"
                    , "Ashok Park Main"
                    , "Inderlok"
                    , "Satguru Ram Singh Marg"
                    , "Kirti Nagar"


            };
            int temp = -1;
            double last_dist = Double.MAX_VALUE;
            for (int i = 0; i < lats.length; i++) {
                double curr_dist = Math.sqrt(Math.pow(lats[i] - lat, 2) + Math.pow(longs[i] - lng, 2));
                if (curr_dist < last_dist) {
                    last_dist = curr_dist;
                    temp = i;
                }
            }
            textView.setText("Nearest Station is " + stations[temp]);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }
}
