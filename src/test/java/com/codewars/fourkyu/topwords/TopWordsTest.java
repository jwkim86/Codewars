package com.codewars.fourkyu.topwords;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TopWordsTest {
    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        List<String> actual = TopWords.top3("a a a  b  c c  d d d d  e e e e e");
        assertThat(actual).containsExactly("e", "d", "a");
        assertThat(TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")).containsExactly("e", "ddd", "aa");
        assertThat(TopWords.top3("  //wont won't won't ")).containsExactly("won't", "wont");
        assertThat(TopWords.top3("  , e   .. ")).containsExactly("e");
        assertThat(TopWords.top3("  ...  ")).isEmpty();
        assertThat(TopWords.top3("  '  ")).isEmpty();
        assertThat(TopWords.top3("  '''  ")).isEmpty();
        assertThat(TopWords.top3("'a 'A 'a' a'A' a'a'!")).isIn(List.of("'a", "a'a'", "'a'"), List.of("a'a'", "'a", "'a'"));
        assertThat(TopWords.top3("""
                         In a village of La Mancha, the name of which I have no desire to call to
                         mind, there lived not long since one of those gentlemen that keep a lance
                         in the lance-rack, an old buckler, a lean hack, and a greyhound for
                         coursing. An olla of rather more beef than mutton, a salad on most
                         nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
                         on Sundays, made away with three-quarters of his income."""
        )).containsExactly("a", "of", "on");
        assertThat(TopWords.top3("''b '','','','' ' '.''B, x''x")).containsExactly("''b", "x''x");
        assertThat(TopWords.top3("MZUfL  mzuFl_'sCVP'GxuJ?_MSlhj'GcFg ;VosG'wqY//''d 'ScvP'GXUj_?ZX'GOUdgnd, oyKdBWBQ lgUzN XgFJd,/''d; DgEPkhY  oYkdBwbQ-dGepKhy 'ScvP'GXUj/xgfJD dTpvyw  lGuZN;?QfpTBwaqDs  qFPtbWaQDS;cNLQv! NfxMt'?LGUZN  XGFjd/zX'gouDgNd: mzuFL:nFxMt', Mslhj'GCfG VosG'Wqy. MzufL  cNlQv/ ''d  'ScVP'gXuJ? LgUZn-!'sCvP'GxUJ_nFxMT' XGFJd mZUFL  DgEpkhy!Vosg'WQY.oyKdbwBQ,,''D  ''D, Zx'gOUdgND -CTZMuWR ''d  dgEPKhY/LguZN.!CnLqv ''d DgEpkHY?cnlQv-Q'ZZt'tQr ''D? mZuFl:.OYKDBWbq  OykdbWbq-'sCvP'Gxuj:qfptbWAqDS/ DGEPkHy_/XgfJd:zx'gOuDGND cnlqV;vOsg'wqy  oYkDbWBq: 'ScvP'GxUj-!CnlQV  'OzbRqtMCM,vosG'wQY dGEpkhY,;cnLqv,XGFjd/LGUZN/ cNlqv xGfjD ?nfxmT' 'scVp'Gxuj:vosG'WQY DGePkhy/.''d DGEpKHy!mzUFl,/lGUzn,qFPtbwAQDS  xGFjd,/NFXmT',.xgFJd  LgUzn vOSg'WQy:OykdBwbq Zx'gOUDgNd  lguzn  ctZMuWR, OyKDbwbq,dtPVyw  zX'GOuDgND  mZUfL;.lgUzn, xgFjD :OYKDbWbq/;ctzMuwR!/DGEpkhY-.voSg'Wqy;OyKDbWbq DTPvYW?CNLQV_ q'zzT'tQr/nFXmt'/ voSg'wqY DgEPkHY.;voSg'Wqy-XGfjD :MSLHj'GCfg._xgfjd? OyKdbWbq ZX'goudGnD?DGEpKHY  MZUFL lGuZn q'Zzt'TQr ''d,Vosg'wqY! DGEPkhY_dgepKhY;Nfxmt'.mZUfl. xgfJD DGepKHy  LGUzn /lgUzn ''D Q'zzT'TQr  OykDbWbq -q'zZt'tqr?'ozbRQtmCM 'SCvP'gXUj?oYkdBwbQ/VOsg'WqY.Q'zzT'TQR?OYKDBwbQ_;xgfJD 'sCvp'gXUJ mzuFL ?UaeRFk'MCA QfPtbWAQDs!DtPvYW.NFXmT'/ MZUfl!xgfJd_Zx'gOuDgND ,''D  lgUzN: mZUFl? nfXMt' cNLQv  NFxmt'?DGepKHY ;''D dGepkhy? VOsG'wQY VOsg'wQy _IWVssvDph!MZufl  DTPvyw/LGuZn xGfjd;q'zZT'TQr_CNLqV !LguZN ''d!''d!QFPTBwAQDS?_DgePkhy  OykDbWBq  XGFJD cNlQv? CNLqV:LGUzn ,vosg'wQY /'iVbG:cNlqV:'SCVp'Gxuj?MZufl :msLHJ'gCFg _oYKdBWBQ cNlqv  lGUzn cnlQV?Cnlqv cnLqV  ''D 'sCVp'gxUj  CTzmuWR ''D VoSG'WqY? uaeRfk'mCa,XgfJD :oYKdBwBq?_'ScVp'GXUj;XgfjD  nfxmT' QfpTbwAQdS  OYkDBwbQ VOSG'wQY cnLQv?:VoSG'wQY VoSg'wQy  MsLhj'gCFG  xGfJd oykdBwbQ! ''D/ OYKdbWBQ.;OYkDBWBq! CNLqV xgFjD. VoSg'Wqy dgepKhy nFxMt' vOSg'wqY  dgePkHy/mSlHj'gcFG  ZX'GOUdgnd mzuFL: lGuzn--'scVp'Gxuj DtpVyw:mSLHJ'gCfg ,''D lGUzN -q'ZzT'TQR  VosG'wQY  ''d xGFJD?;MzufL  ZX'gOudgND-_'ScVP'gxuj CTZmuwR?Q'zzT'tQr Zx'GouDGnD- nFXmT' DGEPKhY,?OYkDbwbq MZUfl  DGepkHY  oykDBWbQ _'scvp'gXUJ.,Cnlqv cNLqV ?CTZmuWR cnlQv! cNlQv.CTzmUWR  XGFjD MZUFL DgepKhy,'scvp'GxuJ!vOsg'WQy CNlQv/ qFpTBWAqds -dgEpkHy_/vOSg'wQy:LGUzN  nFXmt' MZUFl- CNLQv !DGePKHy ?xgfJd  ctZmUWR oYKDbwbq:ctzMUwr:lguZn  CnLQv--'IVbg:,MZufL .mzUFL  'sCVP'GXUj-DGEpKHy_;Zx'GOudgNd;xGFjD LGUZN  lGuZn/,cnLQV. dgepKhY -QFptBwAqds:-''d.CtZmUwr,'iVbg.-'OZbrqTMCm LguZn:Q'ZzT'TQR;vOsg'WQy !oyKDbWbq_ 'IVBg ;q'zzT'Tqr  QfPtBwaQdS ZX'gouDgNd:'sCvp'GXUj MZUfL oyKDBwbQ/ mslhj'gCfg-!zX'gOUDGNd,'ScVP'gxuJ nFXMt' zX'gOUDGND!-''D Zx'gOUdgND."))
                .containsExactly("cnlqv", "dgepkhy", "oykdbwbq");
    }

    @Test
    void sampleTests2() {
        assertThat(TopWords.top3("MZUfL  mzuFl_'sCVP'GxuJ?_MSlhj'GcFg ;VosG'wqY//''d 'ScvP'GXUj_?ZX'GOUdgnd, oyKdBWBQ lgUzN XgFJd,/''d; DgEPkhY  oYkdBwbQ-dGepKhy 'ScvP'GXUj/xgfJD dTpvyw  lGuZN;?QfpTBwaqDs  qFPtbWaQDS;cNLQv! NfxMt'?LGUZN  XGFjd/zX'gouDgNd: mzuFL:nFxMt', Mslhj'GCfG VosG'Wqy. MzufL  cNlQv/ ''d  'ScVP'gXuJ? LgUZn-!'sCvP'GxUJ_nFxMT' XGFJd mZUFL  DgEpkhy!Vosg'WQY.oyKdbwBQ,,''D  ''D, Zx'gOUdgND -CTZMuWR ''d  dgEPKhY/LguZN.!CnLqv ''d DgEpkHY?cnlQv-Q'ZZt'tQr ''D? mZuFl:.OYKDBWbq  OykdbWbq-'sCvP'Gxuj:qfptbWAqDS/ DGEPkHy_/XgfJd:zx'gOuDGND cnlqV;vOsg'wqy  oYkDbWBq: 'ScvP'GxUj-!CnlQV  'OzbRqtMCM,vosG'wQY dGEpkhY,;cnLqv,XGFjd/LGUZN/ cNlqv xGfjD ?nfxmT' 'scVp'Gxuj:vosG'WQY DGePkhy/.''d DGEpKHy!mzUFl,/lGUzn,qFPtbwAQDS  xGFjd,/NFXmT',.xgFJd  LgUzn vOSg'WQy:OykdBwbq Zx'gOUDgNd  lguzn  ctZMuWR, OyKDbwbq,dtPVyw  zX'GOuDgND  mZUfL;.lgUzn, xgFjD :OYKDbWbq/;ctzMuwR!/DGEpkhY-.voSg'Wqy;OyKDbWbq DTPvYW?CNLQV_ q'zzT'tQr/nFXmt'/ voSg'wqY DgEPkHY.;voSg'Wqy-XGfjD :MSLHj'GCfg._xgfjd? OyKdbWbq ZX'goudGnD?DGEpKHY  MZUFL lGuZn q'Zzt'TQr ''d,Vosg'wqY! DGEPkhY_dgepKhY;Nfxmt'.mZUfl. xgfJD DGepKHy  LGUzn /lgUzn ''D Q'zzT'TQr  OykDbWbq -q'zZt'tqr?'ozbRQtmCM 'SCvP'gXUj?oYkdBwbQ/VOsg'WqY.Q'zzT'TQR?OYKDBwbQ_;xgfJD 'sCvp'gXUJ mzuFL ?UaeRFk'MCA QfPtbWAQDs!DtPvYW.NFXmT'/ MZUfl!xgfJd_Zx'gOuDgND ,''D  lgUzN: mZUFl? nfXMt' cNLQv  NFxmt'?DGepKHY ;''D dGepkhy? VOsG'wQY VOsg'wQy _IWVssvDph!MZufl  DTPvyw/LGuZn xGfjd;q'zZT'TQr_CNLqV !LguZN ''d!''d!QFPTBwAQDS?_DgePkhy  OykDbWBq  XGFJD cNlQv? CNLqV:LGUzn ,vosg'wQY /'iVbG:cNlqV:'SCVp'Gxuj?MZufl :msLHJ'gCFg _oYKdBWBQ cNlqv  lGUzn cnlQV?Cnlqv cnLqV  ''D 'sCVp'gxUj  CTzmuWR ''D VoSG'WqY? uaeRfk'mCa,XgfJD :oYKdBwBq?_'ScVp'GXUj;XgfjD  nfxmT' QfpTbwAQdS  OYkDBwbQ VOSG'wQY cnLQv?:VoSG'wQY VoSg'wQy  MsLhj'gCFG  xGfJd oykdBwbQ! ''D/ OYKdbWBQ.;OYkDBWBq! CNLqV xgFjD. VoSg'Wqy dgepKhy nFxMt' vOSg'wqY  dgePkHy/mSlHj'gcFG  ZX'GOUdgnd mzuFL: lGuzn--'scVp'Gxuj DtpVyw:mSLHJ'gCfg ,''D lGUzN -q'ZzT'TQR  VosG'wQY  ''d xGFJD?;MzufL  ZX'gOudgND-_'ScVP'gxuj CTZmuwR?Q'zzT'tQr Zx'GouDGnD- nFXmT' DGEPKhY,?OYkDbwbq MZUfl  DGepkHY  oykDBWbQ _'scvp'gXUJ.,Cnlqv cNLqV ?CTZmuWR cnlQv! cNlQv.CTzmUWR  XGFjD MZUFL DgepKhy,'scvp'GxuJ!vOsg'WQy CNlQv/ qFpTBWAqds -dgEpkHy_/vOSg'wQy:LGUzN  nFXmt' MZUFl- CNLQv !DGePKHy ?xgfJd  ctZmUWR oYKDbwbq:ctzMUwr:lguZn  CnLQv--'IVbg:,MZufL .mzUFL  'sCVP'GXUj-DGEpKHy_;Zx'GOudgNd;xGFjD LGUZN  lGuZn/,cnLQV. dgepKhY -QFptBwAqds:-''d.CtZmUwr,'iVbg.-'OZbrqTMCm LguZn:Q'ZzT'TQR;vOsg'WQy !oyKDbWbq_ 'IVBg ;q'zzT'Tqr  QfPtBwaQdS ZX'gouDgNd:'sCvp'GXUj MZUfL oyKDBwbQ/ mslhj'gCfg-!zX'gOUDGNd,'ScVP'gxuJ nFXMt' zX'gOUDGND!-''D Zx'gOUdgND."))
                .containsExactly("cnlqv", "dgepkhy", "oykdbwbq");
    }
}