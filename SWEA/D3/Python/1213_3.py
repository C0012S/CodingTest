"""
1213. [S/W 문제해결 기본] 3일차 - String

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 10초 / Java의 경우 20초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
        Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition.

    위 문장에서 ti 를 검색하면, 답은 4이다.

    [제약 사항]
        총 10개의 테스트 케이스가 주어진다.
        문장의 길이는 1000자를 넘어가지 않는다.
        한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
        한 문장에서는 하나의 문자열만 검색한다.

    [입력]
        각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.

    [출력]
        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.


    입력
        1
        ti
        Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition
        2
        ing
        Thedoublehelixformsthestructuralbasisofsemi-conservativeDNAreplication.1,2Lessintuitively,italsohasimplicationsontheinformationcontentofDNAfordouble-strandedDNAassuchonlyhasabouthalfthestoragecapacityofsingle-strandedDNA.Thisisbecauseagivensequenceanditsreversecomplement,whilethesameinthedouble-strandedform,aredifferententitiesinsingle-strandedDNA?exceptforthosesequenceswhichareidenticaltotheirreversecomplement
        3
        th
        Lemierresyndromeiscausedbyaninfectionintheoropharyngealregionwithsubsequentthrombophlebitisintheinternaljugularvein.Thethrombusfromthethrombophlebitiscaninvadeothervitalorgans,suchasliver,lungs,orjoints,resultinginsecondaryinfection,whichfurtherexacerbatesthefatalprognosisofthissyndrome.Lemierresyndrome,alsocalledpostanginalsepsisornecrobacillosis,wasfirstreportedbyDr.Lemierrein1936.Inhisreport,Lemierrementionedthatoutof20patientswhosufferedfromthissyndrome,onlytwosurvived.Healsostatedthatallofthe20patientscomplainedofinfectionsinthepalatinetonsilsanddevelopedsepsisandthrombophlebitisintheinternaljugularvein.Oncecalleda"forgottendisease,"thissyndromeshowedaveryhighmortalityrateuntilusageofantibioticsbecameprevalent
        4
        tion
        Non-applicationdecreasedshootlengthandreducednumberofunnecessarysecondaryshootsby39%comparedwiththeconventionalrate,notaffectingyieldandweight,color,firmness,andsolublesolidsoffruits.Nosignificantdifferencewasalsofoundintheyieldandthefruitcharacteristicsamongthetreesfertilizedwithdifferentrates.Concentrationsofsolublesugars,starch,N,andKofdormantshootsinMarchofthefollowingyearwerenotsignificantlychangedbythedifferenttreatmentsofthepreviousyear.Therewasnosignificantdifferenceofshootgrowthandyieldamongthetreatmentsthefollowingyearwhenthesamefertilizationratewassuppliedtoallthetrees
        5
        to
        Duetoincreasedinterestincharactercostumes,thefieldofanimationcharactercostumedesignisgraduallydevelopingintoaspecializeddomain.Thecostume-makingprocessforanimationcharacterspresentsmanydifferencesfromthecostume-makingprocessforregularapparel.However,thereremainsinsufficientresearchontheactualprocessofmakingthecharactercostumesusedinstopmotionvideosbothinKoreaandabroad.Thepurposeofthisstudyistoestablishacostumedesignprocessforanimationcharacters.Furthermore,thisstudypresentsacasestudyonthecostumeplanningandmakingprocessfor3Dstopmotionanimationcharacters.Thecharactercostume-makingprocesswassegmentalizedintothefollowingstages:characteranalysisstage,charactermodelingstage,andcharactercostumemakingstage
        6
        by
        InKorea,noinstitutionaltoolorregulationexistsbywhicharetailbusinessinchargeofgatheringandmaintainingsubscriberscanbeguaranteedindependencefromthewholesalebusinessdivisionofafixedincumbentproviderofessentialfacilitiessuchasducts,polesandcopperorfibercables,whichmayalsobeofferingthesameproductstoitsrivals.Forthatreason,awholesaledivisionmayhaveanincentivetointentionallydisruptthesharingoffacilitiesrequestedbycompetitiveoperatorsincooperationwiththeretaildivision.Ultimately,thefacilitysharingprocesswillremaininactivewhenthereisalackofequivalentaccesstothefixedaccessnetwork
        7
        as
        Theaimofthisstudywastofindtypologyoffashion-relatedmobileapplicationsthroughexploratoryinvestigationandtoinvestigatedifferencesinKoreaandU.S.Appstores.Andthen,throughthequalitativeevaluationaboutfashionmobileapplications,thisstudyproposesfashionmobileapplication'sdesignandcontentswhichcanbepreferredbyusers.Byconductingkeywordsearchineachstore,122Koreanapplicationsand150USapplicationswereanalyzed.Empiricalfindingsrevealedthatthereweresevenmajortypesoffashionmobileapplications:brand,magazine,information,SNS,game,shoppingandcoordination.Informationtypeapplicationstookupthelargestportion,andSNSandgametypeapplicationsshowedhigherrankingamongcustomers
        8
        the
        rimaryvaricellainfectionusuellyrunsabenignclinicalcourseinthehelthypopulation.However,hemorrhagicchickenpoxpresentswithaveryextensiveeruptionofhemorrhagicvesiclesinpatientswithdecreaedplateletsorimpairedimmunityandisaccompaniedbysevereconstitutionalsymptoms.A7-year-oldmalewasadmiduetoabdompalpainfor1dayandpeneralizedvesiculareruptionfor5days.Theeruptionfirstappearedonthetrunkandthenspreadtoinvolvedface,scalpandextrsmities.Theskinrashwascompatablewithvaricellabutdespitetheadministrationofacclovirintravenously,thevesiculareruptionbecamehemorrhagic.Tendaysafteradmission,havingexperiencedcardiscarresttwiceandwithhismentalstateincoms,hewasdisehargedashissituationwashopelesa
        9
        of
        Thebookconsistsofthirteenchaptersinfiveparts.InthefirstpartHarmlessdescribessomeofthegeneralandreligiousbackgroundtofourth-andfifth-centuryEgypt,whichhelpstoplacewhatfollowsinabroadercontext.InhissecondparthediscussesAntonyandPachomius,althoughheacknowledgesthatAntonyisnotthehistoricalbeginningofmonasticism.HemovesnexttodiscusstheDesertFathers,exploringsomeofthetexts,characters,themes,locations,andhistories.Thisleadsthewayforreflectionsonthetheologyandworksoftwomonastictheologians,EvagriusPonticusandJohnCassian.Itmayseemoddatfirstglancethatthefinalsectionofthebook(?쁒eflections??shouldaddresstheoriginsofmonasticism,butHarmlessjustifiesthisfromhisexperienceasaneducator;peoplefinditeasiertoengagewithscholarlydiscussionsconcerningmonasticoriginsoncetheyarefamiliarwiththecharacters,texts,andthemes
        10
        es
        Intheinitialstage,domesticgamesbasedonlineconcentratedongamedevelopmentfocusingonincomeforsomegenres.However,variouscontentsfocusingonsmartenvironmentandsocialnetworkareexpandedatpresentandgamematerialsaredevelopedformorevariousobjects.So,thisstudyintendstoexaminenewcategory,positivegame,fromtheaspectofgamedesignerforgameapproachbasedonvariousobjects.And,gameapproachingprocessinthecategorybasedonpleasurewasorganizedfromthestandpointofdesigner,forthedesignerapproachintheprecedentstageofpositivegamedevelopment.Fromtheaspectofdesigner,systemicityofgamecategoryanddesignapproacharenecessarytoexpandwire-wirelessenvironmentandnewenvironmentbasedontheconvergencemediatointeractivecontentsfocusingongames

    출력
        #1 4
        #2 2
        #3 19
        #4 4
        #5 6
        #6 2
        #7 5
        #8 5
        #9 8
        #10 14
"""


for t in range(1, 11):
    T = int(input()) # 테스트 케이스의 번호
    search = input() # 찾을 문자열
    letters = input() # 검색할 문장

    nums = letters.count(search) # 특정한 문자열의 개수
    # count 함수는 문자열에서 사용 가능하며 튜플, 리스트, 집합과 같은 반복 가능한 iterable 자료형에서도 사용 가능하다.
    # dictionary, set 자료형에서는 count 함수 사용이 불가능하다.

    print("#%d" % t, nums)
