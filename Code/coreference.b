:- modeh(1,corefers(+word,+word)).

:- modeb(*,nameNP(+word)).
:- modeb(*,not(nameNP(+word))).
:- modeb(*,indefinite(+word)).
:- modeb(*,not(indefiniteNP(+word))).
:- modeb(*,definiteNP(+word)).
:- modeb(*,not(definiteNP(+word))).
:- modeb(*,bareNP(+word)).
:- modeb(*,not(bareNP(+word))).
:- modeb(*,pronounNP(+word)).
:- modeb(*,not(pronounNP(+word))).
:- modeb(*,string_match_head(+word,+word)).
:- modeb(*,not(string_match_head(+word,+word))).
:- modeb(*,string_match_full(+word,+word)).
:- modeb(*,not(string_match_full(+word,+word))).
:- modeb(*,string_match_contain(+word,+word)).
:- modeb(*,not(string_match_contain(+word,+word))).

:- set(interactive, true).
:- set(noise,100).
:- set(minacc,0.07).

:- determination(corefers/2,nameNP/1).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,indefiniteNP/1).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,definiteNP/1).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,bareNP/1).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,pronounNP/1).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,string_match_head/2).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,string_match_full/2).
:- determination(corefers/2,(not)/1).
:- determination(corefers/2,string_match_contain/2).
:- determination(corefers/2,(not)/1).
nameNP("Fas_m3").
nameNP("Fas-associated phosphatase-1 _m8").
nameNP("FAP-1_m9").
nameNP("endothelin ( ET ) isoforms_m12").
nameNP("endothelin _m13").
nameNP("ET-1, ET-2 and ET-3_m15").
nameNP("endothelin isoforms_m17").
nameNP("ETA receptor antagonist BQ123_m20").
nameNP("ETA receptor_m21").
nameNP("ETB receptor antagonist BQ788_m22").
nameNP("ETB receptor_m23").
nameNP("ET-1 stimulated growth_m28").
nameNP("fibroblasts_m30").
nameNP("carcinoma cells_m31").
nameNP("growth of the fibroblast cell line_m34").
nameNP("BQ123 _m35").
nameNP("growth of the PE014 carcinoma cell line_m37").
nameNP("mouse embryo fibroblasts (MEF)_m46").
nameNP("C3H10T1/2 MEFs_m51").
nameNP("CYP1A1 activity_m54").
nameNP("Hepa-1c1c7 mouse hepatoma cells (Hepa)_m55").
nameNP("CYP1B1 and CYP1A1 mRNA_m59").
nameNP("EtP_m61").
nameNP("CYP1B1 _m65").
nameNP("p38 mitogen-activated kinase_m68").
nameNP("MAPK_m69").
nameNP("p38 MAPK phosphorylation_m70").
nameNP("BQ-123_m72").
nameNP("endothelin-B receptor antagonist_m73").
nameNP("BQ-788_m74").
nameNP("p38 MAPK inhibitor_m76").
nameNP("contractions elicited by endothelin ( ET ) ligands in human bronchus_m81").
nameNP("endothelin _m82").
nameNP("contractions induced by sarafotoxin S6c or ET-1_m92").
nameNP("responses to sarafotoxin S6c and ET-1_m96").
nameNP("The increase in PI turnover evoked by ET-1_m99").
nameNP("p27Kip1_m109").
nameNP("Cip/Kip_m110").
nameNP("cyclin-dependent kinase _m111").
nameNP("endothelin ETA receptor antagonist, BQ-123_m118").
nameNP("CPSF_m129").
nameNP("30-kD polypeptide_m130").
nameNP("CPSF subunits_m132").
nameNP("30-kD protein_m134").
nameNP("RNA polymers_m135").
nameNP("YTH1_m137").
nameNP("PF I_m139").
nameNP("Yth1p _m140").
nameNP("PF I_m141").
nameNP("PF I_m143").
nameNP("PIP2_m147").
nameNP("PIP2_m150").
nameNP("cardiac Na+/Ca2+ exchanger_m152").
nameNP("laminin_m159").
nameNP("laminin_m162").
nameNP("p70 S6 kinase_m167").
nameNP("p70(S6k)_m168").
nameNP("mitogen-activated protein kinase_m169").
nameNP("S6 protein of the 40s ribosomal subunit_m171").
nameNP("a neuronally enriched protein_m175").
nameNP("p70(S6k)_m176").
nameNP("neurabin_m177").
nameNP("p70(S6k)_m179").
nameNP("neurabin_m181").
nameNP("its PDZ domain_m182").
nameNP("p70(S6k)_m184").
nameNP("its PDZ domain_m185").
nameNP("neuronal-specific neurabin_m187").
nameNP("The fusion gene CBFB-MYH11_m188").
nameNP("CBFbeta_m191").
nameNP("smooth-muscle myosin heavy chain_m192").
nameNP("SMMHC_m193").
nameNP("chimeric protein CBFbeta-SMMHC_m194").
nameNP("function of CBF_m195").
nameNP("Differentiating cells_m197").
nameNP("changes in the chromatin structure_m200").
nameNP("glial cell line-derived neurotrophic factor_m206").
nameNP("Neurturin _m208").
nameNP("NTN_m209").
nameNP("PSP_m211").
nameNP("Artemin_m212").
nameNP("LMN_m221").
nameNP("HD cells_m224").
nameNP("Fas _m228").
nameNP("CD95_m229").
nameNP("Fas ligand_m230").
nameNP("FasL_m231").
nameNP("staphylococcal enterotoxin B_m232").
nameNP("upregulation of FasL_m234").
nameNP("FasL_m236").
nameNP("T cell antigen receptor_m238").
nameNP("TCR_m239").
nameNP("SLP-76 linker protein_m240").
nameNP("nck_m241").
nameNP("adaptor protein_m242").
nameNP("Vav_m243").
nameNP("guanine nucleotide exchange factor for Rho-family GTPases_m244").
nameNP("this tri-molecular complex_m245").
nameNP("CREB _m248").
nameNP("a brain region that is important for addiction_m251").
nameNP("blockade of kappa opioid receptors_m253").
nameNP("Dpp_m258").
nameNP("receptor tyrosine kinases_m259").
nameNP("RTKs_m260").
nameNP("Drosophila epidermal growth factor receptor_m261").
nameNP("Heartless _m263").
nameNP("mitogen-associated protein kinase_m265").
nameNP("MAPK_m266").
nameNP("these RTKs_m267").
nameNP("melanocortin-5 receptor_m269").
nameNP("MC5-R_m270").
nameNP("class III semaphorins_m272").
nameNP("Sema III, Sema E, and Sema IV_m273").
nameNP("meprin, A5, mu_m279").
nameNP("LTP_m281").
nameNP("RARbeta deficiency in mice_m284").
nameNP("retinoid receptors_m286").
nameNP("prion protein_m289").
nameNP("PrP_m290").
nameNP("PrP(Sc)_m294").
nameNP("pathogenic isoform of PrP_m295").
nameNP("Vnd_m296").
nameNP("a NK-2 homeodomain protein_m297").
nameNP("Vnd_m298").
nameNP("Germ-line stem cells_m301").
nameNP("GSCs_m302").
nameNP("Drosophila piwi gene_m303").
nameNP("the mutated gene_m306").
nameNP("Smbp2, Rip1, Gf1, or Catf1_m308").
nameNP("chromosome _m310").
nameNP("Boundary elements_m313").
nameNP("polytene chromosome interband loci_m316").
nameNP("candidate boundary elements_m318").

bareNP("FAP-1_m1").
bareNP("Fas-mediated apoptosis_m2").
bareNP("Fas-mediated apoptosis_m11").
bareNP("ET_m14").
bareNP("125I-ET binding_m19").
bareNP("BQ 123_m24").
bareNP("BQ 788_m25").
bareNP("growth_m26").
bareNP("nifedipine_m41").
bareNP("SKF 96365_m43").
bareNP("CYP1B1_m45").
bareNP("1-ethynylpyrene_m47").
bareNP("1EP_m48").
bareNP("DMBA_m50").
bareNP("1PP_m53").
bareNP("DMBA metabolism_m57").
bareNP("DMBA metabolism_m62").
bareNP("carbon monoxide_m63").
bareNP("CO_m64").
bareNP("SB203580_m77").
bareNP("phosphatidyl inositol_m79").
bareNP("PI_m80").
bareNP("ET_m83").
bareNP("Ca2+-free medium_m86").
bareNP("contractions_m87").
bareNP("intracellular calcium mobilization_m90").
bareNP("KCI concentration-response curves_m93").
bareNP("SB 209670_m95").
bareNP("BQ-123_m97").
bareNP("SB 209670_m100").
bareNP("BQ-123_m101").
bareNP("kinase activity_m113").
bareNP("Inotropic effects_m114").
bareNP("Cleavage and polyadenylation specificity factor_m128").
bareNP("this protein_m131").
bareNP("purified polyadenylation factor I_m138").
bareNP("Fip1p_m142").
bareNP("Na+/Ca2+ exchange_m145").
bareNP("neural and muscle agrin_m153").
bareNP("muscle fibers_m154").
bareNP("agrin_m156").
bareNP("agrin_m158").
bareNP("agrin_m161").
bareNP("p70 S6 kinase_m165").
bareNP("neurabin_m173").
bareNP("neurabin_m180").
bareNP("This gene_m189").
bareNP("This dominant suppression_m196").
bareNP("which_m201").
bareNP("PF_m203").
bareNP("This ability_m205").
bareNP("GDNF_m207").
bareNP("head direction_m218").
bareNP("HD_m219").
bareNP("anterior thalamus_m222").
bareNP("ATN_m223").
bareNP("SEB_m233").
bareNP("This effect_m235").
bareNP("which_m237").
bareNP("this topographic map_m247").
bareNP("this region_m252").
bareNP("which_m254").
bareNP("Wg_m256").
bareNP("DER_m262").
bareNP("Htl_m264").
bareNP("ACTH/MSH peptides_m268").
bareNP("sympathetic axons_m275").
bareNP("long-term depression_m282").
bareNP("LTD_m283").
bareNP("this gene_m309").
bareNP("Chr_m311").
bareNP("cBEs_m319").

definiteNP("its expression_m4").
definiteNP("its biological function_m6").
definiteNP("their_m16").
definiteNP("their_m18").
definiteNP("The increases_m40").
definiteNP("these reactions_m75").
definiteNP("the response_m103").
definiteNP("The protein sequence_m133").
definiteNP("the exchanger_m151").
definiteNP("their_m155").
definiteNP("its PDZ domain_m182").
definiteNP("its PDZ domain_m185").
definiteNP("The fusion gene CBFB-MYH11_m188").
definiteNP("their_m199").
definiteNP("its expression pattern_m213").
definiteNP("their directional firing properties_m225").
definiteNP("their_m226").
definiteNP("these RTKs_m267").
definiteNP("these peptides_m271").
definiteNP("these semaphorins_m274").
definiteNP("their responses_m276").
definiteNP("their_m277").
definiteNP("These mice_m292").
definiteNP("these mice_m293").
definiteNP("its action_m299").
definiteNP("the mutated gene_m306").
definiteNP("their_m314").
definiteNP("these sites_m317").

indefiniteNP("both antagonists_m27").
indefiniteNP("both receptor types_m29").
indefiniteNP("each cell type_m56").
indefiniteNP("each inhibitor_m58").
indefiniteNP("Both_m117").
indefiniteNP("Both_m122").
indefiniteNP("both proteins_m160").
indefiniteNP("a neuronally enriched protein_m175").
indefiniteNP("a NK-2 homeodomain protein_m297").

pronounNP("those_m88").
pronounNP("It_m170").
pronounNP("it_m215").
pronounNP("them_m227").
pronounNP("It_m285").
pronounNP("they_m287").
pronounNP("it_m304").

nameNP("p70 (S6k)_m178").
nameNP("adenosine 3^, 5'-monophosphate response element binding protein_m249").

string_match_full("FAP-1_m1","FAP-1_m9").
string_match_full("Fas-mediated apoptosis_m2","Fas-mediated apoptosis_m11").
string_match_full("Fas_m3","Fas _m228").
string_match_full("its_m5","its_m7").
string_match_full("its_m5","its_m127").
string_match_full("its_m5","its_m183").
string_match_full("its_m5","its_m186").
string_match_full("its_m5","its_m214").
string_match_full("its_m5","its_m300").
string_match_full("its_m7","its_m127").
string_match_full("its_m7","its_m183").
string_match_full("its_m7","its_m186").
string_match_full("its_m7","its_m214").
string_match_full("its_m7","its_m300").
string_match_full("which _m10","which_m201").
string_match_full("which _m10","which_m237").
string_match_full("which _m10","which_m254").
string_match_full("endothelin _m13","endothelin _m82").
string_match_full("ET_m14","ET_m83").
string_match_full("their_m16","their_m18").
string_match_full("their_m16","their_m155").
string_match_full("their_m16","their_m199").
string_match_full("their_m16","their_m226").
string_match_full("their_m16","their_m277").
string_match_full("their_m16","their_m314").
string_match_full("their_m18","their_m155").
string_match_full("their_m18","their_m199").
string_match_full("their_m18","their_m226").
string_match_full("their_m18","their_m277").
string_match_full("their_m18","their_m314").
string_match_full("BQ123 _m35","BQ123_m38").
string_match_full("CYP1B1_m45","CYP1B1 _m65").
string_match_full("DMBA metabolism_m57","DMBA metabolism_m62").
string_match_full("MAPK_m69","MAPK_m266").
string_match_full("ET(A) receptor antagonist_m71","ET(A) receptor antagonist_m98").
string_match_full("BQ-123_m72","BQ-123_m97").
string_match_full("BQ-123_m72","BQ-123_m101").
string_match_full("SB 209670_m95","SB 209670_m100").
string_match_full("BQ-123_m97","BQ-123_m101").
string_match_full("raclopride_m106","raclopride _m107").
string_match_full("It _m112","It_m170").
string_match_full("It _m112","It_m285").
string_match_full("positive inotropic response in the neonate_m115","positive inotropic response in the neonate_m120").
string_match_full("negative response in the adult_m116","negative response in the adult_m121").
string_match_full("Both_m117","Both_m122").
string_match_full("its_m127","its_m183").
string_match_full("its_m127","its_m186").
string_match_full("its_m127","its_m214").
string_match_full("its_m127","its_m300").
string_match_full("PF I_m139","PF I_m141").
string_match_full("PF I_m139","PF I_m143").
string_match_full("PF I_m141","PF I_m143").
string_match_full("PIP2_m147","PIP2_m150").
string_match_full("their_m155","their_m199").
string_match_full("their_m155","their_m226").
string_match_full("their_m155","their_m277").
string_match_full("their_m155","their_m314").
string_match_full("agrin_m156","agrin_m158").
string_match_full("agrin_m156","agrin_m161").
string_match_full("agrin_m158","agrin_m161").
string_match_full("laminin_m159","laminin_m162").
string_match_full("p70 S6 kinase_m165","p70 S6 kinase_m167").
string_match_full("p70(S6k)_m168","p70(S6k)_m176").
string_match_full("p70(S6k)_m168","p70(S6k)_m179").
string_match_full("p70(S6k)_m168","p70(S6k)_m184").
string_match_full("It_m170","It_m285").
string_match_full("neurabin_m173","neurabin_m177").
string_match_full("neurabin_m173","neurabin_m180").
string_match_full("neurabin_m173","neurabin_m181").
string_match_full("p70(S6k)_m176","p70(S6k)_m179").
string_match_full("p70(S6k)_m176","p70(S6k)_m184").
string_match_full("neurabin_m177","neurabin_m180").
string_match_full("neurabin_m177","neurabin_m181").
string_match_full("p70(S6k)_m179","p70(S6k)_m184").
string_match_full("neurabin_m180","neurabin_m181").
string_match_full("its PDZ domain_m182","its PDZ domain_m185").
string_match_full("its_m183","its_m186").
string_match_full("its_m183","its_m214").
string_match_full("its_m183","its_m300").
string_match_full("its_m186","its_m214").
string_match_full("its_m186","its_m300").
string_match_full("their_m199","their_m226").
string_match_full("their_m199","their_m277").
string_match_full("their_m199","their_m314").
string_match_full("which_m201","which_m237").
string_match_full("which_m201","which_m254").
string_match_full("its_m214","its_m300").
string_match_full("it_m215","it_m304").
string_match_full("their_m226","their_m277").
string_match_full("their_m226","their_m314").
string_match_full("FasL_m231","FasL_m236").
string_match_full("which_m237","which_m254").
string_match_full("their_m277","their_m314").
string_match_full("transgenic mice_m288","transgenic mice_m291").
string_match_full("Vnd_m296","Vnd_m298").

string_match_head("FAP-1_m1","FAP-1_m9").
string_match_head("Fas-mediated apoptosis_m2","Fas-mediated apoptosis_m11").
string_match_head("Fas_m3","Fas-associated phosphatase-1 _m8").
string_match_head("Fas_m3","Fas-mediated apoptosis_m11").
string_match_head("Fas_m3","Fas _m228").
string_match_head("Fas_m3","Fas ligand_m230").
string_match_head("Fas_m3","FasL_m231").
string_match_head("Fas_m3","FasL_m236").
string_match_head("which _m10","which_m201").
string_match_head("which _m10","which_m237").
string_match_head("which _m10","which_m254").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin _m13").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin isoforms_m17").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin-A_m66").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin-B receptor antagonist_m73").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin _m82").
string_match_head("endothelin ( ET ) isoforms_m12","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_head("endothelin _m13","endothelin isoforms_m17").
string_match_head("endothelin _m13","endothelin-A_m66").
string_match_head("endothelin _m13","endothelin-B receptor antagonist_m73").
string_match_head("endothelin _m13","endothelin _m82").
string_match_head("endothelin _m13","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_head("ET_m14","ET-1, ET-2 and ET-3_m15").
string_match_head("ET_m14","ETA receptor antagonist BQ123_m20").
string_match_head("ET_m14","ETA receptor_m21").
string_match_head("ET_m14","ETB receptor antagonist BQ788_m22").
string_match_head("ET_m14","ETB receptor_m23").
string_match_head("ET_m14","ET-1 stimulated growth_m28").
string_match_head("ET_m14","ET(A)_m67").
string_match_head("ET_m14","ET(A) receptor antagonist_m71").
string_match_head("ET_m14","ET_m83").
string_match_head("ET_m14","ET(A)/ET(B) receptor antagonist_m94").
string_match_head("ET_m14","ET(A) receptor antagonist_m98").
string_match_head("ET_m14","ET(B) receptor-mediated contraction in human bronchial smooth muscle_m102").
string_match_head("ET-1, ET-2 and ET-3_m15","ET-1 stimulated growth_m28").
string_match_head("endothelin isoforms_m17","endothelin-A_m66").
string_match_head("endothelin isoforms_m17","endothelin-B receptor antagonist_m73").
string_match_head("endothelin isoforms_m17","endothelin _m82").
string_match_head("endothelin isoforms_m17","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_head("ETA receptor antagonist BQ123_m20","ETA receptor_m21").
string_match_head("ETB receptor antagonist BQ788_m22","ETB receptor_m23").
string_match_head("BQ 123_m24","BQ 788_m25").
string_match_head("BQ 123_m24","BQ123 _m35").
string_match_head("BQ 123_m24","BQ788_m36").
string_match_head("BQ 123_m24","BQ123_m38").
string_match_head("BQ 123_m24","BQ-123_m72").
string_match_head("BQ 123_m24","BQ-788_m74").
string_match_head("BQ 123_m24","BQ-123_m97").
string_match_head("BQ 123_m24","BQ-123_m101").
string_match_head("BQ 788_m25","BQ123 _m35").
string_match_head("BQ 788_m25","BQ788_m36").
string_match_head("BQ 788_m25","BQ123_m38").
string_match_head("BQ 788_m25","BQ-123_m72").
string_match_head("BQ 788_m25","BQ-788_m74").
string_match_head("BQ 788_m25","BQ-123_m97").
string_match_head("BQ 788_m25","BQ-123_m101").
string_match_head("growth_m26","growth of the fibroblast cell line_m34").
string_match_head("growth_m26","growth of the PE014 carcinoma cell line_m37").
string_match_head("growth of the fibroblast cell line_m34","growth of the PE014 carcinoma cell line_m37").
string_match_head("BQ123 _m35","BQ123_m38").
string_match_head("nifedipine_m41","nifedipine-resistant increase_m42").
string_match_head("CYP1B1_m45","CYP1B1 and CYP1A1 mRNA_m59").
string_match_head("CYP1B1_m45","CYP1B1 _m65").
string_match_head("DMBA_m50","DMBA metabolism_m57").
string_match_head("DMBA_m50","DMBA metabolism_m62").
string_match_head("DMBA metabolism_m57","DMBA metabolism_m62").
string_match_head("CYP1B1 and CYP1A1 mRNA_m59","CYP1B1 _m65").
string_match_head("ET(A)_m67","ET(A) receptor antagonist_m71").
string_match_head("ET(A)_m67","ET(A)/ET(B) receptor antagonist_m94").
string_match_head("ET(A)_m67","ET(A) receptor antagonist_m98").
string_match_head("p38 mitogen-activated kinase_m68","p38 MAPK phosphorylation_m70").
string_match_head("p38 mitogen-activated kinase_m68","p38 MAPK inhibitor_m76").
string_match_head("MAPK_m69","MAPK_m266").
string_match_head("p38 MAPK phosphorylation_m70","p38 MAPK inhibitor_m76").
string_match_head("ET(A) receptor antagonist_m71","ET(A)/ET(B) receptor antagonist_m94").
string_match_head("ET(A) receptor antagonist_m71","ET(A) receptor antagonist_m98").
string_match_head("BQ-123_m72","BQ-123_m97").
string_match_head("BQ-123_m72","BQ-123_m101").
string_match_head("PI_m80","PIP2_m147").
string_match_head("PI_m80","PIP2_m150").
string_match_head("contractions elicited by endothelin ( ET ) ligands in human bronchus_m81","contractions_m87").
string_match_head("contractions elicited by endothelin ( ET ) ligands in human bronchus_m81","contractions induced by sarafotoxin S6c or ET-1_m92").
string_match_head("endothelin _m82","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_head("ET_m83","ET(A)/ET(B) receptor antagonist_m94").
string_match_head("ET_m83","ET(A) receptor antagonist_m98").
string_match_head("ET_m83","ET(B) receptor-mediated contraction in human bronchial smooth muscle_m102").
string_match_head("contractions_m87","contractions induced by sarafotoxin S6c or ET-1_m92").
string_match_head("SB 209670_m95","SB 209670_m100").
string_match_head("BQ-123_m97","BQ-123_m101").
string_match_head("raclopride_m106","raclopride _m107").
string_match_head("positive inotropic response in the neonate_m115","positive inotropic response in the neonate_m120").
string_match_head("negative response in the adult_m116","negative response in the adult_m121").
string_match_head("30-kD subunit of mammalian cleavage and polyadenylation specificity factor_m125","30-kD polypeptide_m130").
string_match_head("30-kD subunit of mammalian cleavage and polyadenylation specificity factor_m125","30-kD protein_m134").
string_match_head("CPSF_m129","CPSF subunits_m132").
string_match_head("30-kD polypeptide_m130","30-kD protein_m134").
string_match_head("PF I_m139","PF I_m141").
string_match_head("PF I_m139","PF I_m143").
string_match_head("PF I_m139","PF_m203").
string_match_head("PF I_m141","PF I_m143").
string_match_head("PF I_m141","PF_m203").
string_match_head("PF I_m143","PF_m203").
string_match_head("Na+/Ca2+ exchange in cardiac sarcolemmal vesicles_m144","Na+/Ca2+ exchange_m145").
string_match_head("PIP2_m147","PIP2_m150").
string_match_head("neural and muscle agrin_m153","neural agrin--induced AChR aggregates_m157").
string_match_head("agrin_m156","agrin_m158").
string_match_head("agrin_m156","agrin_m161").
string_match_head("agrin_m158","agrin_m161").
string_match_head("laminin_m159","laminin_m162").
string_match_head("p70 S6 kinase_m165","p70 S6 kinase_m167").
string_match_head("p70 S6 kinase_m165","p70(S6k)_m168").
string_match_head("p70 S6 kinase_m165","p70(S6k)_m176").
string_match_head("p70 S6 kinase_m165","p70 (S6k)_m178").
string_match_head("p70 S6 kinase_m165","p70(S6k)_m179").
string_match_head("p70 S6 kinase_m165","p70(S6k)_m184").
string_match_head("neuronal cytoskeleton_m166","neuronal-specific neurabin_m187").
string_match_head("p70 S6 kinase_m167","p70(S6k)_m168").
string_match_head("p70 S6 kinase_m167","p70(S6k)_m176").
string_match_head("p70 S6 kinase_m167","p70 (S6k)_m178").
string_match_head("p70 S6 kinase_m167","p70(S6k)_m179").
string_match_head("p70 S6 kinase_m167","p70(S6k)_m184").
string_match_head("p70(S6k)_m168","p70(S6k)_m176").
string_match_head("p70(S6k)_m168","p70(S6k)_m179").
string_match_head("p70(S6k)_m168","p70(S6k)_m184").
string_match_head("neurabin_m173","neurabin_m177").
string_match_head("neurabin_m173","neurabin_m180").
string_match_head("neurabin_m173","neurabin_m181").
string_match_head("p70(S6k)_m176","p70(S6k)_m179").
string_match_head("p70(S6k)_m176","p70(S6k)_m184").
string_match_head("neurabin_m177","neurabin_m180").
string_match_head("neurabin_m177","neurabin_m181").
string_match_head("p70 (S6k)_m178","p70(S6k)_m179").
string_match_head("p70 (S6k)_m178","p70(S6k)_m184").
string_match_head("p70(S6k)_m179","p70(S6k)_m184").
string_match_head("neurabin_m180","neurabin_m181").
string_match_head("which_m201","which_m237").
string_match_head("which_m201","which_m254").
string_match_head("HD_m219","HD cells_m224").
string_match_head("Fas _m228","Fas ligand_m230").
string_match_head("Fas _m228","FasL_m231").
string_match_head("Fas _m228","FasL_m236").
string_match_head("Fas ligand_m230","FasL_m231").
string_match_head("Fas ligand_m230","FasL_m236").
string_match_head("FasL_m231","FasL_m236").
string_match_head("which_m237","which_m254").
string_match_head("T cell antigen receptor_m238","TCR_m239").
string_match_head("Drosophila epidermal growth factor receptor_m261","Drosophila piwi gene_m303").
string_match_head("long-term potentiation_m280","long-term depression_m282").
string_match_head("transgenic mice_m288","transgenic mice_m291").
string_match_head("PrP_m290","PrP(Sc)_m294").
string_match_head("Vnd_m296","Vnd_m298").

string_match_contain("Fas_m3","upregulation of FasL_m234").
string_match_contain("endothelin _m13","contractions elicited by endothelin ( ET ) ligands in human bronchus_m81").
string_match_contain("ET_m14","ET-1, ET-2 and ET-3_m15").
string_match_contain("ET_m14","125I-ET binding_m19").
string_match_contain("ET_m14","morphological changes associated with ET-1-induced myocardial cell hypertrophy_m78").
string_match_contain("ET_m14","contractions elicited by endothelin ( ET ) ligands in human bronchus_m81").
string_match_contain("ET_m14","contractions induced by sarafotoxin S6c or ET-1_m92").
string_match_contain("ET_m14","ET(A)/ET(B) receptor antagonist_m94").
string_match_contain("ET_m14","responses to sarafotoxin S6c and ET-1_m96").
string_match_contain("ET_m14","The increase in PI turnover evoked by ET-1_m99").
string_match_contain("ET_m14","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("ETA receptor_m21","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("growth_m26","ET-1 stimulated growth_m28").
string_match_contain("growth_m26","Drosophila epidermal growth factor receptor_m261").
string_match_contain("fibroblasts_m30","mouse embryo fibroblasts (MEF)_m46").
string_match_contain("ET(A)_m67","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("MAPK_m69","p38 MAPK phosphorylation_m70").
string_match_contain("MAPK_m69","p38 MAPK inhibitor_m76").
string_match_contain("ET(A) receptor antagonist_m71","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("BQ-123_m72","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("PI_m80","The increase in PI turnover evoked by ET-1_m99").
string_match_contain("ET_m83","contractions induced by sarafotoxin S6c or ET-1_m92").
string_match_contain("ET_m83","ET(A)/ET(B) receptor antagonist_m94").
string_match_contain("ET_m83","responses to sarafotoxin S6c and ET-1_m96").
string_match_contain("ET_m83","The increase in PI turnover evoked by ET-1_m99").
string_match_contain("ET_m83","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("BQ-123_m97","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("ET(A) receptor antagonist_m98","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("BQ-123_m101","endothelin ETA receptor antagonist, BQ-123_m118").
string_match_contain("agrin_m156","neural agrin--induced AChR aggregates_m157").
string_match_contain("neurabin_m173","neuronal-specific neurabin_m187").
string_match_contain("neurabin_m177","neuronal-specific neurabin_m187").
string_match_contain("neurabin_m180","neuronal-specific neurabin_m187").
string_match_contain("neurabin_m181","neuronal-specific neurabin_m187").
string_match_contain("CBFbeta_m191","chimeric protein CBFbeta-SMMHC_m194").
string_match_contain("SMMHC_m193","chimeric protein CBFbeta-SMMHC_m194").
string_match_contain("FasL_m231","upregulation of FasL_m234").
string_match_contain("RTKs_m260","these RTKs_m267").
string_match_contain("PrP_m290","pathogenic isoform of PrP_m295").
string_match_contain("chromosome _m310","polytene chromosome interband loci_m316").

