nombre_m([aeron, aethelred, alaric, alberich, aldric, anton, araios,
         bardolf, boromir, brandr, caelan, caelum, caius, callum,
         casimir, celt, cormac, daeron, darion, darius, davion,
         edgar, elric, eric, eustace, faolan, faran,fede, fletcher,
         garrett, gideon, griffin, haakon, hakon, hjalmar, hodric,
         hugh, igor, ivar, jaeger, kael, kaelan, kaelthas, kieran,
         laenor, laertes, lauriel, leander, leif, leod,lucas, lucien, lyndon,
         malachi, marcus, marlon, merlin, morgun, norman, odin,
         oliver, oswald, ragnar, raiden, ragnarok, ragnarsson]).

 nombre_f([aella, aethelflaed, aife, alais, alara, alva, ambrosia,
         anya, arabella, arianrhod, astraea, audrey, aurelia,
         beata, brigid, caera, calypso, cassia, celestine,
         chloe, cora, dahlia, daniela, elara, elaine,
         elenora, eluned, esmeralda, esther, evelyn, faela,
         felicity, flora, freya, galadriel, gwendolyn, hela,
         irene, isabella, isolda, ivana, juniper, kaela,
         laila, leandra, lyra, maeve,
         maira, marian, medea, merida, morwen, myra,
         naomi, nimue, nissa, nyx, octavia, oona, oriana,
         phoenix, rianna, riven, rose, selene, seraphina,
         shae, silvia, talia, talwyn, thea, titania, valeria,
         vivian, xena, yara, yennefer, ysera]).


adjetivo_f([valiente, sabia, fuerte, astuta, hermosa, misteriosa,
         compasiva, leal, independiente, tenaz, audaz, serena,
         enigmatica, poderosa, elocuente, intrepida, cautelosa,
         perspicaz, sabia, noble, gracil, agil, veloz,
         letal, implacable, salvaje, enigmatica, oscura,
         brillante, radiante, celestial, lunar, solar,
         antigua, ancestral, mistica, magica, elemental,
         natural, salvaje, indomable, rebelde, libre]).

adjetivo_m([valeroso, sabio, poderoso, astuto, imponente, enigmatico,
         agil, indomable, estrategico, feroz, disciplinado, energico,
          intrepido, leal, implacable, misterioso, sagaz, protector,
           brillante, desafiante, visionario, majestuoso, imbatible, 
           resuelto, ingenioso, virtuoso, sutil, audaz, letal, protector,
            magnanimo, oscuro, desafiante, impetuoso, heroico, astuto,
             indestructible, calculador, hechicero, arrojado, sereno,
              imperioso, leal, protector]).



% Selecciona un elemento aleatorio de una lista
seleccionar_aleatorio(Lista, Elemento) :-
    length(Lista, Longitud),
    Longitud > 0,
    random(0, Longitud, Index),
    nth0(Index, Lista, Elemento).


nombre_personaje_femenino(NombreCompleto) :-
    nombre_f(NombresF),
    adjetivo_f(AdjetivosF),
    seleccionar_aleatorio(NombresF, NombreF),
    seleccionar_aleatorio(AdjetivosF, AdjetivoF),
    atomic_list_concat(['La', AdjetivoF, NombreF], ' ', NombreCompleto).

nombre_personaje_masculino(NombreCompleto) :-
    nombre_m(NombresM),
    adjetivo_m(AdjetivosM),
    seleccionar_aleatorio(NombresM, NombreM),
    seleccionar_aleatorio(AdjetivosM, AdjetivoM),
    atomic_list_concat(['El', AdjetivoM, NombreM], ' ', NombreCompleto).



% Magos clasificados

% Estudiantes
mago('Harry Potter', estudiante).
mago('Hermione Granger', estudiante).
mago('Ron Weasley', estudiante).
mago('Neville Longbottom', estudiante).
mago('Luna Lovegood', estudiante).
mago('Ginny Weasley', estudiante).
mago('Cedric Diggory', estudiante).
mago('Dean Thomas', estudiante).
mago('Seamus Finnigan', estudiante).
mago('Fred Weasley', estudiante).
mago('George Weasley', estudiante).
mago('Parvati Patil', estudiante).
mago('Lavender Brown', estudiante).
mago('Cho Chang', estudiante).
mago('Susan Bones', estudiante).
mago('Ernie Macmillan', estudiante).
mago('Hannah Abbott', estudiante).
mago('Michael Corner', estudiante).
mago('Anthony Goldstein', estudiante).


% Profesores
mago('Minerva McGonagall', profesor).
mago('Remus Lupin', profesor).
mago('Filius Flitwick', profesor).
mago('Pomona Sprout', profesor).
mago('Gilderoy Lockhart', profesor).
mago('Dolores Umbridge', profesor).
mago('Horace Slughorn', profesor).
mago('Madam Hooch', profesor).
mago('Sybil Trelawney', profesor).
mago('Rolanda Hooch', profesor).
mago('Albus Dumbledore', profesor).
mago('Brenda Schereik', profesor).
mago('Francisco Franco', profesor).
mago('Martha Barra', profesor).
mago('Federico Gasior', profesor).
mago('Lucas Videla', profesor).

% Aurores
mago('Nymphadora Tonks', auror).
mago('Alastor Moody', auror).
mago('Kingsley Shacklebolt', auror).
mago('Hestia Jones', auror).
mago('Sturgis Podmore', auror).
mago('Tonks', auror).
mago('Isaias Altamiranda', auror).
mago('Ximena Pastori', auror).


% Mortífagos clasificados

% Comandantes
mortifago('Lord Voldemort', comandante).
mortifago('Lucius Malfoy', comandante).
mortifago('Barty Crouch Jr.', comandante).
mortifago('Severus Snape', comandante).
mortifago('Alecto Carrow', comandante).
mortifago('Amycus Carrow', comandante).
mortifago('Peter Pettigrew', comandante).

% Seguidores
mortifago('Narcissa Malfoy', seguidor).
mortifago('Vincent Crabbe', seguidor).
mortifago('Gregory Goyle', seguidor).
mortifago('Theo Nott', seguidor).
mortifago('Fenrir Greyback', seguidor).
mortifago('Antonin Dolohov', seguidor).
mortifago('Walden Macnair', seguidor).
mortifago('Corban Yaxley', seguidor).
mortifago('Mulciber', seguidor).
mortifago('Travers', seguidor).
mortifago('Augustus Rookwood', seguidor).
