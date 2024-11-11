hechizo(ataquebasico,5).
hechizo(expelliarmus,30).
hechizo(glaciusmaxima,50).
hechizo(avadakedavra,100).
hechizo(protego,20).
hechizo(desmaius,10).
hechizo(confringo,70).
hechizo(bombarda,40).
hechizo(crucio,80).

hechizo(vitalisrevoco,50).
hechizo(reverse,60).
hechizo(fulminislacertae,40).
hechizo(petrificus,40).
hechizo(incendio,30).

energia_suficiente(Hechizo,Mana,NivelHechizo):-
    hechizo(Hechizo,NivelHechizo),
     Mana >= NivelHechizo.